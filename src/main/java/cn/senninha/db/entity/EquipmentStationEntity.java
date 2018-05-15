package cn.senninha.db.entity;

import javax.validation.constraints.NotNull;

public class EquipmentStationEntity extends EquipmentEntity{
    private String stationCode;
    private String stationName;
    private String temperature;
    private String humidity;

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
