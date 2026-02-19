package br.com.certvision.response;

import java.util.Date;

public class CertificateResponse {

    private String issuer;
    private Date expirationDate;
    private Date startCertificateDate;

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
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
