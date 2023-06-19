package hu.menetrendekplus.backend.dto.response;

import java.util.List;
import java.util.Objects;

public class RouteDto {

    private String startingStation;

    private String arrivingStation;

    private String startingTime;

    private String arrivingTime;

    private int changeCount;

    private String duration;

    private List<String> routeOperatesOn;

    private double distance;

    private FareDto fares;

    private List<LineDto> lines;

    public RouteDto(String startingStation, String arrivingStation, String startingTime, String arrivingTime, int changeCount, String duration, List<String> routeOperatesOn, double distance, FareDto fares, List<LineDto> lines) {
        this.startingStation = startingStation;
        this.arrivingStation = arrivingStation;
        this.startingTime = startingTime;
        this.arrivingTime = arrivingTime;
        this.changeCount = changeCount;
        this.duration = duration;
        this.routeOperatesOn = routeOperatesOn;
        this.distance = distance;
        this.fares = fares;
        this.lines = lines;
    }

    public RouteDto() {
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

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getArrivingTime() {
        return arrivingTime;
    }

    public void setArrivingTime(String arrivingTime) {
        this.arrivingTime = arrivingTime;
    }

    public int getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(int changeCount) {
        this.changeCount = changeCount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<String> getRouteOperatesOn() {
        return routeOperatesOn;
    }

    public void setRouteOperatesOn(List<String> routeOperatesOn) {
        this.routeOperatesOn = routeOperatesOn;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public FareDto getFares() {
        return fares;
    }

    public void setFares(FareDto fares) {
        this.fares = fares;
    }

    public List<LineDto> getLines() {
        return lines;
    }

    public void setLines(List<LineDto> lines) {
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteDto routeDto = (RouteDto) o;
        return changeCount == routeDto.changeCount && Double.compare(routeDto.distance, distance) == 0 && Objects.equals(startingStation, routeDto.startingStation) && Objects.equals(arrivingStation, routeDto.arrivingStation) && Objects.equals(startingTime, routeDto.startingTime) && Objects.equals(arrivingTime, routeDto.arrivingTime) && Objects.equals(duration, routeDto.duration) && Objects.equals(routeOperatesOn, routeDto.routeOperatesOn) && Objects.equals(fares, routeDto.fares) && Objects.equals(lines, routeDto.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startingStation, arrivingStation, startingTime, arrivingTime, changeCount, duration, routeOperatesOn, distance, fares, lines);
    }

    @Override
    public String toString() {
        return "RouteDto{" +
                "startingStation='" + startingStation + '\'' +
                ", arrivingStation='" + arrivingStation + '\'' +
                ", startingTime='" + startingTime + '\'' +
                ", arrivingTime='" + arrivingTime + '\'' +
                ", changeCount=" + changeCount +
                ", duration='" + duration + '\'' +
                ", routeOperatesOn=" + routeOperatesOn +
                ", distance=" + distance +
                ", fares=" + fares +
                ", lines=" + lines +
                '}';
    }
}
