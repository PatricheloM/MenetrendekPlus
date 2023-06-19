package hu.menetrendekplus.backend.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Station {

    private String settlement_name;

    private String lsname;

    private int ls_id;

    private int settlement_id;

    public String getSettlement_name() {
        return settlement_name;
    }

    public void setSettlement_name(String settlement_name) {
        this.settlement_name = settlement_name;
    }

    public String getLsname() {
        return lsname;
    }

    public void setLsname(String lsname) {
        this.lsname = lsname;
    }

    public int getLs_id() {
        return ls_id;
    }

    public void setLs_id(int ls_id) {
        this.ls_id = ls_id;
    }

    public int getSettlement_id() {
        return settlement_id;
    }

    public void setSettlement_id(int settlement_id) {
        this.settlement_id = settlement_id;
    }
}
