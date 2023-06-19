package hu.menetrendekplus.backend.model.request;

public class GetRoutes {

    private String datum;

    private String honnan;

    private int honnan_ls_id;

    private int honnan_settlement_id;

    private String hova;

    private int hova_ls_id;

    private int hova_settlement_id;

    private int hour;

    private int min;

    private final int napszak = 3;

    private int maxatszallas;

    private int maxwalk;

    private final int naptipus = 0;

    private final int odavissza = 0;

    private final int preferencia = 1;

    private final String utirany = "oda";

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getHonnan() {
        return honnan;
    }

    public void setHonnan(String honnan) {
        this.honnan = honnan;
    }

    public int getHonnan_ls_id() {
        return honnan_ls_id;
    }

    public void setHonnan_ls_id(int honnan_ls_id) {
        this.honnan_ls_id = honnan_ls_id;
    }

    public int getHonnan_settlement_id() {
        return honnan_settlement_id;
    }

    public void setHonnan_settlement_id(int honnan_settlement_id) {
        this.honnan_settlement_id = honnan_settlement_id;
    }

    public String getHova() {
        return hova;
    }

    public void setHova(String hova) {
        this.hova = hova;
    }

    public int getHova_ls_id() {
        return hova_ls_id;
    }

    public void setHova_ls_id(int hova_ls_id) {
        this.hova_ls_id = hova_ls_id;
    }

    public int getHova_settlement_id() {
        return hova_settlement_id;
    }

    public void setHova_settlement_id(int hova_settlement_id) {
        this.hova_settlement_id = hova_settlement_id;
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

    public int getNapszak() {
        return napszak;
    }

    public int getMaxatszallas() {
        return maxatszallas;
    }

    public void setMaxatszallas(int maxatszallas) {
        this.maxatszallas = maxatszallas;
    }

    public int getMaxwalk() {
        return maxwalk;
    }

    public void setMaxwalk(int maxwalk) {
        this.maxwalk = maxwalk;
    }

    public int getNaptipus() {
        return naptipus;
    }

    public int getOdavissza() {
        return odavissza;
    }

    public int getPreferencia() {
        return preferencia;
    }

    public String getUtirany() {
        return utirany;
    }
}
