package br.com.piovezan.certvision.service;

import br.com.piovezan.certvision.domain.CertificateDto;
import br.com.piovezan.certvision.mapper.CertificateMapper;
import br.com.piovezan.certvision.model.Certificate;
import br.com.piovezan.certvision.repository.CertificateRepository;
import br.com.piovezan.certvision.request.CertVisionRequest;
import br.com.piovezan.certvision.response.CertVisionResponse;
import br.com.piovezan.certvision.response.CertVisionResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.net.URI;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;

import static java.util.Arrays.stream;

@Service
public class CertVisionService {

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private CertificateMapper mapper;

    public CertVisionResponse validateCertificate(CertVisionRequest certVisionRequest) {
        try {

            URL url = URI.create(certVisionRequest.getUrl()).toURL();

            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();

            httpsURLConnection.connect();

            CertVisionResponse certVisionResponse = findCertificateInfo(httpsURLConnection);

            System.out.println("Emissor: " + certVisionResponse.getIssuer());
            System.out.println("Válido de: " + certVisionResponse.getStartCertificateDate());
            System.out.println("Válido até: " + certVisionResponse.getExpirationDate());

            httpsURLConnection.disconnect();
            return certVisionResponse;
        } catch (Exception e) {
            System.err.println("Erro ao consultar dados do certificado: {}" + e.getMessage());
        }

        return null;
    }

    private static CertVisionResponse findCertificateInfo(HttpsURLConnection httpsURLConnection) throws SSLPeerUnverifiedException {
        return stream(httpsURLConnection.getServerCertificates())
                .filter(cert -> cert instanceof X509Certificate)
                .map(cert -> (X509Certificate) cert)
                .findFirst()
                .map(CertVisionResponseFactory::fromCertificate)
                .orElse(null);
    }

    public void uploadCertificate(CertificateDto certificateDto) {
        Certificate certificate = mapper.toEntity(certificateDto);
        certificate.setCreate_dt(LocalDateTime.now());
        certificate.setActive(true);
        certificateRepository.save(certificate);
    }
}