package hu.menetrendekplus.backend.dto.response;

import java.util.Objects;

public class StationDto {

    private String StationName;

    private int SettlementId;

    private int StationId;

    public String getStationName() {
        return StationName;
    }

    public void setStationName(String stationName) {
        StationName = stationName;
    }

    public int getSettlementId() {
        return SettlementId;
    }

    public void setSettlementId(int settlementId) {
        SettlementId = settlementId;
    }

    public int getStationId() {
        return StationId;
    }

    public void setStationId(int stationId) {
        StationId = stationId;
    }

    public StationDto(String stationName, int settlementId, int stationId) {
        StationName = stationName;
        SettlementId = settlementId;
        StationId = stationId;
    }

    public StationDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationDto that = (StationDto) o;
        return Objects.equals(StationName, that.StationName) && Objects.equals(SettlementId, that.SettlementId) && Objects.equals(StationId, that.StationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(StationName, SettlementId, StationId);
    }

    @Override
    public String toString() {
        return "StationDto{" +
                "StationName='" + StationName + '\'' +
                ", SettlementId='" + SettlementId + '\'' +
                ", StationId='" + StationId + '\'' +
                '}';
    }
}
