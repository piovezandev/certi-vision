package br.com.piovezan.certvision.service;

import br.com.piovezan.certvision.domain.CompanyDto;
import br.com.piovezan.certvision.mapper.CompanyMapper;
import br.com.piovezan.certvision.model.Company;
import br.com.piovezan.certvision.repository.CompanyRepository;
import br.com.piovezan.certvision.request.RegisterRequest;
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
