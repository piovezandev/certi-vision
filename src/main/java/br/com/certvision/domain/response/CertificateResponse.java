package br.com.certvision.domain.response;

import java.util.Date;

public class CertificateResponse {

    private String issuer;
    private String commonName;
    private String organization;
    private String organizationUnit;
    private Date expirationDate;
    private Date startCertificateDate;
    private boolean expired;
    private int version;
    private String serialNumber;
    private String algorithmSignature;

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getOrganizationUnit() {
        return organizationUnit;
    }

    public void setOrganizationUnit(String organizationUnit) {
        this.organizationUnit = organizationUnit;
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

    public String getAlgorithmSignature() {
        return algorithmSignature;
    }

    public void setAlgorithmSignature(String algorithmSignature) {
        this.algorithmSignature = algorithmSignature;
    }
}
