package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * inzheneher created on 28/07/2020 inside the package - com.mav.entity
 */
@Entity
@Table(name = "requests_log")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp timestamp;
    private Double latitude;
    private Double longitude;
    @Column(columnDefinition="text")
    private String respond;

    protected Request() {
    }

    public Request(Timestamp timestamp, Double latitude, Double longitude, String respond) {
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.respond = respond;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getRespond() {
        return respond;
    }

    @Override
    public String toString() {
        return String.format("RequestLog[id=%s, timestamp=%s, latitude=%s, longitude=%s, respond=%s]",
                id, timestamp, latitude, longitude, respond);
    }
}
