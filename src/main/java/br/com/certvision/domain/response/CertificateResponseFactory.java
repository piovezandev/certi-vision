package br.com.certvision.domain.response;

import java.security.cert.X509Certificate;

public class CertificateResponseFactory {

    public static CertificateResponse fromCertificate(X509Certificate x509) {
        CertificateResponse certificateResponse = new CertificateResponse();
        certificateResponse.setIssuer(x509.getIssuerX500Principal().getName());
        certificateResponse.setStartCertificateDate(x509.getNotBefore());
        certificateResponse.setExpirationDate(x509.getNotAfter());
        return certificateResponse;
    }
}
