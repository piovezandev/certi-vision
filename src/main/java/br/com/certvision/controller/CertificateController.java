package br.com.certvision.controller;

import br.com.certvision.domain.response.CertificateResponse;
import br.com.certvision.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/certificate")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @GetMapping("/info")
    public CertificateResponse getCertificateInfoByUrl(@RequestParam String url) {
      return certificateService.getCertificateInfoByUrl(url);
    }

}
