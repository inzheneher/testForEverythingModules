package utils;

import responses.OpenWeatherResponse;

/**
 * inzheneher created on 29/07/2020 inside the package - utils
 */
public class ResponseAndJson {
    private OpenWeatherResponse response;
    private String json;

    public ResponseAndJson(OpenWeatherResponse response, String json) {
        this.response = response;
        this.json = json;
    }

    public OpenWeatherResponse getResponse() {
        return response;
    }

    public String getJson() {
        return json;
    }
}
