package cn.senninha.db.entity;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EquipmentEntity {
    @Id
    private Integer id;

    private Integer stationId;

    @Size(min=16, max=16, message = "桩编码长度为16个字符")
    @NotNull(message = "充电桩编码必填")
    private String equipmentCode;

    @Min(value = 0, message = "模块数必须大于0")
    @NotNull(message = "充电桩模块数必填")
    private int moduleCount;

    @NotNull(message = "充电桩名称必填")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public int getModuleCount() {
        return moduleCount;
    }

    public void setModuleCount(int moduleCount) {
        this.moduleCount = moduleCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EquipmentEntity{" +
                "id=" + id +
                ", stationId='" + stationId + '\'' +
                ", equipmentCode='" + equipmentCode + '\'' +
                ", moduleCount=" + moduleCount +
                ", name='" + name + '\'' +
                '}';
    }
}
