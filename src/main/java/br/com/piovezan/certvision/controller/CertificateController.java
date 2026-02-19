package br.com.piovezan.certvision.controller;

import br.com.piovezan.certvision.request.CertificateRequest;
import br.com.piovezan.certvision.response.CertificateResponse;
import br.com.piovezan.certvision.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CertificateController {

    @Autowired
    private CertificateService certVisionService;

    @PostMapping("/validate/certificate")
    public CertificateResponse certificate(@RequestBody CertificateRequest request) {
      return certVisionService.validateCertificate(request);
    }
}
