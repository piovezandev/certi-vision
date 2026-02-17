package br.com.piovezan.certvision.response;

import java.util.Date;

public class CertVisionResponse {

    private String organization;
    private Date expirationDate;
    private Date startCertificateDate;

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getStartCertificateDate() {
        return startCertificateDate;
    }

    public void setStartCertificateDate(Date startCertificateDate) {
        this.startCertificateDate = startCertificateDate;
    }
}
