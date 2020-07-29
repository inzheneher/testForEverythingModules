package services;

import com.google.gson.Gson;
import entity.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import repository.IRequestService;
import repository.RequestLogRepository;
import responses.OpenWeatherResponse;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

/**
 * inzheneher created on 22/07/2020 inside the package - services
 */
@Service
public class RequestService implements IRequestService {
    private final RequestLogRepository repository;
    @Value("${units}")
    private String units;
    @Value("${appId}")
    private String appId;
    @Value("${baseUrl}")
    private String baseUrl;

    public RequestService(RequestLogRepository repository) {
        this.repository = repository;
    }

    public OpenWeatherResponse getOpenWeatherResponse(String latitude, String longitude) {
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
        return new Gson().fromJson(response.toString(), OpenWeatherResponse.class);
    }


    @Override
    public List<Request> findAll() {
        return (List<Request>) repository.findAll();
    }

    public Request save(Request request) {
        return repository.save(request);
    }
}
