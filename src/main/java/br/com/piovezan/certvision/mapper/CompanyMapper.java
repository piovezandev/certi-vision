package br.com.piovezan.certvision.mapper;

import br.com.piovezan.certvision.domain.CompanyDto;
import br.com.piovezan.certvision.model.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company toEntity(CompanyDto companyDto);
}
