package br.com.certvision.service;

import br.com.certvision.exceptions.CertficateException;
import br.com.certvision.domain.request.CertificateRequest;
import br.com.certvision.domain.response.CertificateResponse;
import br.com.certvision.domain.response.CertificateResponseFactory;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.net.URI;
import java.net.URL;
import java.security.cert.X509Certificate;

import static java.util.Arrays.stream;

@Service
public class CertificateService {

    public CertificateResponse validateCertificate(CertificateRequest certificateRequest) {
        try {

            URL url = URI.create(certificateRequest.url()).toURL();

            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();

            httpsURLConnection.connect();

            CertificateResponse certificateResponse = findCertificateInfo(httpsURLConnection);
            httpsURLConnection.disconnect();

            return certificateResponse;
        } catch (Exception exception) {
            throw new CertficateException("Erro ao validar certificado", exception);
        }
    }

    private static CertificateResponse findCertificateInfo(HttpsURLConnection httpsURLConnection) throws SSLPeerUnverifiedException {
        return stream(httpsURLConnection.getServerCertificates())
                .filter(cert -> cert instanceof X509Certificate)
                .map(cert -> (X509Certificate) cert)
                .findFirst()
                .map(CertificateResponseFactory::fromCertificate)
                .orElseThrow(() -> new CertficateException("Erro ao consultar dados do certificado"));
    }
}