package br.com.piovezan.certvision.response;

import java.security.cert.X509Certificate;

public class CertVisionResponseFactory {

    public static CertVisionResponse fromCertificate(X509Certificate x509) {
        CertVisionResponse certVisionResponse = new CertVisionResponse();
        certVisionResponse.setIssuer(x509.getIssuerX500Principal().getName());
        certVisionResponse.setStartCertificateDate(x509.getNotBefore());
        certVisionResponse.setExpirationDate(x509.getNotAfter());
        return certVisionResponse;
    }
}
