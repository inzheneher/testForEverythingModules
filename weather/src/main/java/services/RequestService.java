package services;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import responses.OpenWeatherResponse;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

/**
 * inzheneher created on 22/07/2020 inside the package - services
 */
@Service
public class RequestService {
    public OpenWeatherResponse getOpenWeatherResponse(String latitude, String longitude) {
        StringBuilder response = new StringBuilder();
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("weather/src/main/resources/request.properties"));
            String baseUrl = prop.getProperty("baseUrl");
            String units = prop.getProperty("units");
            String appId = prop.getProperty("appId");
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
        return new Gson().fromJson(response.toString(), OpenWeatherResponse.class);
    }
}
