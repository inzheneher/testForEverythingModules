package services;

import com.google.gson.Gson;
import entity.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import responses.OpenWeatherResponse;
import utils.ResponseAndJson;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * inzheneher created on 22/07/2020 inside the package - services
 */
@Service
public class RequestService {
    @Value("${units}")
    private String units;
    @Value("${appId}")
    private String appId;
    @Value("${baseUrl}")
    private String baseUrl;

    public ResponseAndJson getOpenWeatherResponseAndJson(String latitude, String longitude) {
        StringBuilder response = new StringBuilder();
        try {
            String requestUrl = String.format("%slat=%s&lon=%s&units=%s&appid=%s", baseUrl, latitude, longitude, units, appId);
            URL url = new URL(requestUrl);
            HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
            httpsConn.setRequestMethod("GET");
            httpsConn.setRequestProperty("Content-Type", "application/json");
            httpsConn.setConnectTimeout((1000 * 60));
            httpsConn.setReadTimeout((1000 * 60));
            BufferedReader in = new BufferedReader(new InputStreamReader(httpsConn.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) response.append(inputLine);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String _response = response.toString();
        return new ResponseAndJson(new Gson().fromJson(_response, OpenWeatherResponse.class), _response);
    }

    public List<Request> setList(Object o) {
        List<Request> list = new ArrayList<>();
        if (o instanceof List) {
            for (int i = 0; i < ((List<?>) o).size(); i++) {
                Object item = ((List<?>) o).get(i);
                if (item instanceof Request) {
                    list.add((Request) item);
                }
            }
        }
        return list;
    }
}
