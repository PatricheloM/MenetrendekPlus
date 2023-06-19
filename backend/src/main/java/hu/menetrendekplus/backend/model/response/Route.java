package hu.menetrendekplus.backend.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Route {

    private String indulasi_hely;

    private String erkezesi_hely;

    private String indulasi_ido;

    private String erkezesi_ido;

    private int atszallasok_szama;

    private String osszido;

    private Map<String, LineInfo> jaratinfok;

    private Map<String, ChangeInfo> atszallasinfok;

    private List<String> explanations;

    private double totalDistance;

    private int totalFare;

    private int totalFare50;

    private int totalFare90;

    private List<NativeData> nativeData;

    public String getIndulasi_hely() {
        return indulasi_hely;
    }

    public void setIndulasi_hely(String indulasi_hely) {
        this.indulasi_hely = indulasi_hely;
    }

    public String getErkezesi_hely() {
        return erkezesi_hely;
    }

    public void setErkezesi_hely(String erkezesi_hely) {
        this.erkezesi_hely = erkezesi_hely;
    }

    public String getIndulasi_ido() {
        return indulasi_ido;
    }

    public void setIndulasi_ido(String indulasi_ido) {
        this.indulasi_ido = indulasi_ido;
    }

    public String getErkezesi_ido() {
        return erkezesi_ido;
    }

    public void setErkezesi_ido(String erkezesi_ido) {
        this.erkezesi_ido = erkezesi_ido;
    }

    public int getAtszallasok_szama() {
        return atszallasok_szama;
    }

    public void setAtszallasok_szama(int atszallasok_szama) {
        this.atszallasok_szama = atszallasok_szama;
    }

    public String getOsszido() {
        return osszido;
    }

    public void setOsszido(String osszido) {
        this.osszido = osszido;
    }

    public Map<String, LineInfo> getJaratinfok() {
        return jaratinfok;
    }

    public void setJaratinfok(Map<String, LineInfo> jaratinfok) {
        this.jaratinfok = jaratinfok;
    }

    public Map<String, ChangeInfo> getAtszallasinfok() {
        return atszallasinfok;
    }

    public void setAtszallasinfok(Map<String, ChangeInfo> atszallasinfok) {
        this.atszallasinfok = atszallasinfok;
    }

    public List<String> getExplanations() {
        return explanations;
    }

    public void setExplanations(List<String> explanations) {
        this.explanations = explanations;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public int getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(int totalFare) {
        this.totalFare = totalFare;
    }

    public int getTotalFare50() {
        return totalFare50;
    }

    public void setTotalFare50(int totalFare50) {
        this.totalFare50 = totalFare50;
    }

    public int getTotalFare90() {
        return totalFare90;
    }

    public void setTotalFare90(int totalFare90) {
        this.totalFare90 = totalFare90;
    }

    public List<NativeData> getNativeData() {
        return nativeData;
    }

    public void setNativeData(List<NativeData> nativeData) {
        this.nativeData = nativeData;
    }
}
