package hu.menetrendekplus.backend.dto.request;

import java.util.Objects;

public class QueryRoutesDto {

    private String startingStation;

    private String arrivingStation;

    private String date;

    private int hour;

    private int min;

    private int maxChanges;

    private int maxWalk;

    public QueryRoutesDto() {
    }

    public QueryRoutesDto(String startingStation, String arrivingStation, String date, int hour, int min, int maxChanges, int maxWalk) {
        this.startingStation = startingStation;
        this.arrivingStation = arrivingStation;
        this.date = date;
        this.hour = hour;
        this.min = min;
        this.maxChanges = maxChanges;
        this.maxWalk = maxWalk;
    }

    public String getStartingStation() {
        return startingStation;
    }

    public void setStartingStation(String startingStation) {
        this.startingStation = startingStation;
    }

    public String getArrivingStation() {
        return arrivingStation;
    }

    public void setArrivingStation(String arrivingStation) {
        this.arrivingStation = arrivingStation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMaxChanges() {
        return maxChanges;
    }

    public void setMaxChanges(int maxChanges) {
        this.maxChanges = maxChanges;
    }

    public int getMaxWalk() {
        return maxWalk;
    }

    public void setMaxWalk(int maxWalk) {
        this.maxWalk = maxWalk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryRoutesDto that = (QueryRoutesDto) o;
        return hour == that.hour && min == that.min && maxChanges == that.maxChanges && maxWalk == that.maxWalk && Objects.equals(startingStation, that.startingStation) && Objects.equals(arrivingStation, that.arrivingStation) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startingStation, arrivingStation, date, hour, min, maxChanges, maxWalk);
    }

    @Override
    public String toString() {
        return "QueryRoutesDto.json{" +
                "startingStation='" + startingStation + '\'' +
                ", arrivingStation='" + arrivingStation + '\'' +
                ", date='" + date + '\'' +
                ", hour=" + hour +
                ", min=" + min +
                ", maxChanges=" + maxChanges +
                ", maxWalk=" + maxWalk +
                '}';
    }
}
