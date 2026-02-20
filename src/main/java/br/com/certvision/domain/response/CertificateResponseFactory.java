package br.com.certvision.domain.response;

import br.com.certvision.domain.util.CertificateUtils;

import java.security.cert.X509Certificate;

public class CertificateResponseFactory {

    public static CertificateResponse fromCertificate(X509Certificate certificate) {
        CertificateResponse certificateResponse = new CertificateResponse();
        certificateResponse.setIssuer(certificate.getIssuerX500Principal().getName());
        certificateResponse.setCommonName(CertificateUtils.extractCommonName(certificate));
        certificateResponse.setOrganization(CertificateUtils.extractOrganization(certificate));
        certificateResponse.setOrganizationUnit(CertificateUtils.extractOrganizationUnit(certificate));
        certificateResponse.setStartCertificateDate(certificate.getNotBefore());
        certificateResponse.setExpirationDate(certificate.getNotAfter());
        certificateResponse.setExpired(CertificateUtils.isCertificateExpired(certificate));
        certificateResponse.setVersion(certificate.getVersion());
        certificateResponse.setSerialNumber(String.valueOf(certificate.getSerialNumber()));
        certificateResponse.setAlgorithmSignature(certificate.getSigAlgName());
        return certificateResponse;
    }
}
