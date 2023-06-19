package hu.menetrendekplus.backend.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NativeData {

    private String OwnerName;

    private String Domain_code;

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getDomain_code() {
        return Domain_code;
    }

    public void setDomain_code(String domain_code) {
        Domain_code = domain_code;
    }
}
