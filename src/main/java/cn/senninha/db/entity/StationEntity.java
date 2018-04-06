package cn.senninha.db.entity;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StationEntity {
    @Id
    private Integer id;
    private String location;

    @Size(min=16, max=16, message = "站编码长度为16个字符")
    @NotNull(message = "充电桩编码必填")
    private String station_id;

    @NotNull(message = "充电站名称必填")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StationEntity{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", station_id='" + station_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
