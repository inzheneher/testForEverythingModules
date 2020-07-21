import com.google.gson.Gson;
import dao.WeatherResponse;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * inzheneher created on 15/07/2020 inside the package - PACKAGE_NAME WeatherResponse
 */

public class Weather {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.weather.gov/gridpoints/BOX/21,35/forecast");
            HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
            httpsConn.setRequestMethod("GET");
            httpsConn.setRequestProperty("Content-Type", "application/json");
            httpsConn.setConnectTimeout((1000 * 60));
            httpsConn.setReadTimeout((1000 * 60));
            StringBuilder response = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(httpsConn.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            WeatherResponse weatherResponse = new Gson().fromJson(response.toString(), WeatherResponse.class);
            weatherResponse.getProperties().getPeriods().forEach(a ->
                    System.out.printf("Temperature on %s is: %s\n", a.getName(), a.getTemperature()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
