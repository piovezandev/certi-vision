package br.com.piovezan.certvision.service;

import br.com.piovezan.certvision.request.CertVisionRequest;
import br.com.piovezan.certvision.response.CertVisionResponse;
import br.com.piovezan.certvision.utils.NotSecureTrustManager;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class CertVisionService {

    private static final String PROTOCOL_TLS = "TLS";

    public CertVisionResponse validateCertificate(CertVisionRequest request) {
        try {
            return extractCertificate(request.getUrl()).stream().findFirst().map(cert -> {
                CertVisionResponse response = new CertVisionResponse();
                response.setOrganization(cert.getSubjectX500Principal().getName());
                response.setStartCertificateDate(cert.getNotBefore());
                response.setExpirationDate(cert.getNotAfter());
                return response;
            }).orElse(null);
        } catch (KeyManagementException | NoSuchAlgorithmException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Collection<X509Certificate> extractCertificate(String urlStr) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        SSLContext ctx = SSLContext.getInstance(PROTOCOL_TLS);
        ctx.init(null, new TrustManager[]{new NotSecureTrustManager()}, new SecureRandom());

        HttpsURLConnection conn = (HttpsURLConnection) new URL(urlStr).openConnection();

        conn.setHostnameVerifier((host, session) -> true);
        conn.connect();

        List<X509Certificate> certs = Arrays
                .stream(conn.getServerCertificates())
                .filter(cert -> cert instanceof X509Certificate)
                .map(cert -> (X509Certificate) cert)
                .toList();

        conn.disconnect();
        return certs;
    }


}