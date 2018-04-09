package cn.senninha.db.entity;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StationEntity {
    @Id
    private Integer id;
    private String location;

    @Size(min=16, max=16, message = "站编码长度为16个字符")
    @NotNull(message = "充电站编码必填")
    private String stationCode;

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

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
