package br.com.certvision.service;

import br.com.certvision.exceptions.CertificateException;
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

    public CertificateResponse getCertificateInfoByUrl(String url) {
        try {

            URL urlCertificate = URI.create(url).toURL();

            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlCertificate.openConnection();

            httpsURLConnection.connect();

            CertificateResponse certificateResponse = extractCertificateUrl(httpsURLConnection);
            httpsURLConnection.disconnect();

            return certificateResponse;
        } catch (Exception exception) {
            throw new CertificateException("Erro ao consultar dados do certificado: ", exception);
        }
    }

    private static CertificateResponse extractCertificateUrl(HttpsURLConnection httpsURLConnection) throws SSLPeerUnverifiedException {
        return stream(httpsURLConnection.getServerCertificates())
                .filter(cert -> cert instanceof X509Certificate)
                .map(cert -> (X509Certificate) cert)
                .findFirst()
                .map(CertificateResponseFactory::fromCertificate)
                .orElseThrow(() -> new CertificateException("Erro ao extrair dados do certificado"));
    }
}