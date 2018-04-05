package cn.senninha.db.entity;

public class StationEntity {
    private Integer id;
    private String location;
    private String station_id;
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
