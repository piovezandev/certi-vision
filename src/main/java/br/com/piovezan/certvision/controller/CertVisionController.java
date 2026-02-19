package br.com.piovezan.certvision.controller;

import br.com.piovezan.certvision.domain.CertificateDto;
import br.com.piovezan.certvision.request.CertVisionRequest;
import br.com.piovezan.certvision.response.CertVisionResponse;
import br.com.piovezan.certvision.service.CertVisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CertVisionController {

    @Autowired
    private CertVisionService certVisionService;

    @PostMapping("/validate/certificate")
    public CertVisionResponse certificate(@RequestBody CertVisionRequest request) {
        return certVisionService.validateCertificate(request);
    }

    @PostMapping("/certificate/upload")
    public void upload(@RequestBody CertificateDto certificateDto) {
        certVisionService.uploadCertificate(certificateDto);

    }
}
