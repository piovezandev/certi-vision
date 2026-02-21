package br.com.certvision.service;

import br.com.certvision.domain.mapper.CompanyMapper;
import br.com.certvision.domain.model.Company;
import br.com.certvision.domain.request.RegisterRequest;
import br.com.certvision.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CompanyService {

    //TODO implementar mapper
    private CompanyMapper mapper;

    @Autowired
    private CompanyRepository companyRepository;

    public Company create(RegisterRequest request) {

        Company company = new Company();
        company.setName(request.companyName());
        company.setPlan("FREE");
        company.setStatus("ACTIVE");
        company.setMax_endpoints(5);
        company.setCreate_dt(LocalDateTime.now());

        companyRepository.save(company);
        return company;
    }
}
