package dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * inzheneher created on 20/07/2020 inside the package - dao
 */
public class WeatherResponse {

    private String type;
    private GeometryBean geometry;
    private PropertiesBean properties;
    @SerializedName("@context")
    private List<Object> _$Context9; // FIXME check this code

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GeometryBean getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryBean geometry) {
        this.geometry = geometry;
    }

    public PropertiesBean getProperties() {
        return properties;
    }

    public void setProperties(PropertiesBean properties) {
        this.properties = properties;
    }

    public List<Object> get_$Context9() {
        return _$Context9;
    }

    public void set_$Context9(List<Object> _$Context9) {
        this._$Context9 = _$Context9;
    }

    public static class GeometryBean {
        private String type;
        private List<List<List<Double>>> coordinates;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<List<List<Double>>> getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(List<List<List<Double>>> coordinates) {
            this.coordinates = coordinates;
        }
    }

    public static class PropertiesBean {
        private String updated;
        private String units;
        private String forecastGenerator;
        private String generatedAt;
        private String updateTime;
        private String validTimes;
        private ElevationBean elevation;
        private List<PeriodsBean> periods;

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public String getUnits() {
            return units;
        }

        public void setUnits(String units) {
            this.units = units;
        }

        public String getForecastGenerator() {
            return forecastGenerator;
        }

        public void setForecastGenerator(String forecastGenerator) {
            this.forecastGenerator = forecastGenerator;
        }

        public String getGeneratedAt() {
            return generatedAt;
        }

        public void setGeneratedAt(String generatedAt) {
            this.generatedAt = generatedAt;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getValidTimes() {
            return validTimes;
        }

        public void setValidTimes(String validTimes) {
            this.validTimes = validTimes;
        }

        public ElevationBean getElevation() {
            return elevation;
        }

        public void setElevation(ElevationBean elevation) {
            this.elevation = elevation;
        }

        public List<PeriodsBean> getPeriods() {
            return periods;
        }

        public void setPeriods(List<PeriodsBean> periods) {
            this.periods = periods;
        }

        public static class ElevationBean {
            private double value;
            private String unitCode;

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }

            public String getUnitCode() {
                return unitCode;
            }

            public void setUnitCode(String unitCode) {
                this.unitCode = unitCode;
            }
        }

        public static class PeriodsBean {
            private int number;
            private String name;
            private String startTime;
            private String endTime;
            private boolean isDaytime;
            private int temperature;
            private String temperatureUnit;
            private Object temperatureTrend;
            private String windSpeed;
            private String windDirection;
            private String icon;
            private String shortForecast;
            private String detailedForecast;

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public boolean isIsDaytime() {
                return isDaytime;
            }

            public void setIsDaytime(boolean isDaytime) {
                this.isDaytime = isDaytime;
            }

            public int getTemperature() {
                return temperature;
            }

            public void setTemperature(int temperature) {
                this.temperature = temperature;
            }

            public String getTemperatureUnit() {
                return temperatureUnit;
            }

            public void setTemperatureUnit(String temperatureUnit) {
                this.temperatureUnit = temperatureUnit;
            }

            public Object getTemperatureTrend() {
                return temperatureTrend;
            }

            public void setTemperatureTrend(Object temperatureTrend) {
                this.temperatureTrend = temperatureTrend;
            }

            public String getWindSpeed() {
                return windSpeed;
            }

            public void setWindSpeed(String windSpeed) {
                this.windSpeed = windSpeed;
            }

            public String getWindDirection() {
                return windDirection;
            }

            public void setWindDirection(String windDirection) {
                this.windDirection = windDirection;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getShortForecast() {
                return shortForecast;
            }

            public void setShortForecast(String shortForecast) {
                this.shortForecast = shortForecast;
            }

            public String getDetailedForecast() {
                return detailedForecast;
            }

            public void setDetailedForecast(String detailedForecast) {
                this.detailedForecast = detailedForecast;
            }
        }
    }
}
