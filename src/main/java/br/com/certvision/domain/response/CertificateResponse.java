package br.com.certvision.domain.response;

import java.util.Date;

public class CertificateResponse {

    private String issuer;
    private String subject;
    private Date expirationDate;
    private Date startCertificateDate;
    private boolean expired;
    private int version;
    private String serialNumber;

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
