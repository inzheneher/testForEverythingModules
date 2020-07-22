import com.google.gson.Gson;
import responses.OpenWeatherResponse;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

/**
 * inzheneher created on 15/07/2020 inside the package - PACKAGE_NAME WeatherResponse
 */

public class Weather {

    public static void main(String[] args) {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("weather/src/main/resources/request.properties"));
            //TODO: get coordinates from web page
            String baseUrl = prop.getProperty("baseUrl");
            String lat = "-19.134422";
            String lon = "131.638687";
            String units = prop.getProperty("units");
            String appId = prop.getProperty("appId");
            String requestUrl = String.format("%slat=%s&lon=%s&units=%s&appid=%s", baseUrl, lat, lon, units, appId);
            URL url = new URL(requestUrl);
            HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
            httpsConn.setRequestMethod("GET");
            httpsConn.setRequestProperty("Content-Type", "application/json");
            httpsConn.setConnectTimeout((1000 * 60));
            httpsConn.setReadTimeout((1000 * 60));
            StringBuilder response = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(httpsConn.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) response.append(inputLine);
            in.close();
            OpenWeatherResponse weatherResponse = new Gson().fromJson(response.toString(), OpenWeatherResponse.class);
            System.out.printf("Temperature in %s is: %s\u00B0C", weatherResponse.getSys().getCountry(), weatherResponse.getMain().getTemp());
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
