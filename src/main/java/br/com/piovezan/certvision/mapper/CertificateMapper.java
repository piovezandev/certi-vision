package br.com.piovezan.certvision.mapper;

import br.com.piovezan.certvision.domain.CertificateDto;
import br.com.piovezan.certvision.model.Certificate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface CertificateMapper {

    Certificate toEntity(CertificateDto certificateDto);
}
