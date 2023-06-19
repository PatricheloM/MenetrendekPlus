package hu.menetrendekplus.backend.dto.response;

import java.util.Objects;

public class LineDto {

    private String lineName;

    private String changeStation;

    private String lineOwner;

    private String lineCode;

    public LineDto(String lineName, String changeStation, String lineOwner, String lineCode) {
        this.lineName = lineName;
        this.changeStation = changeStation;
        this.lineOwner = lineOwner;
        this.lineCode = lineCode;
    }

    public LineDto(String lineName, String lineOwner, String lineCode) {
        this.lineName = lineName;
        this.lineOwner = lineOwner;
        this.lineCode = lineCode;
    }

    public LineDto() {
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getChangeStation() {
        return changeStation;
    }

    public void setChangeStation(String changeStation) {
        this.changeStation = changeStation;
    }

    public String getLineOwner() {
        return lineOwner;
    }

    public void setLineOwner(String lineOwner) {
        this.lineOwner = lineOwner;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineDto lineDto = (LineDto) o;
        return Objects.equals(lineName, lineDto.lineName) && Objects.equals(changeStation, lineDto.changeStation) && Objects.equals(lineOwner, lineDto.lineOwner) && Objects.equals(lineCode, lineDto.lineCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineName, changeStation, lineOwner, lineCode);
    }

    @Override
    public String toString() {
        return "LineDto{" +
                "lineName='" + lineName + '\'' +
                ", changeStation='" + changeStation + '\'' +
                ", lineOwner='" + lineOwner + '\'' +
                ", lineCode='" + lineCode + '\'' +
                '}';
    }
}
