package br.com.piovezan.certvision.domain;

import br.com.piovezan.certvision.enums.Type;

import java.time.LocalDateTime;

public record CertificateDto(String name, LocalDateTime expiration_dt, Type type) {
}
