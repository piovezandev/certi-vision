package br.com.certvision.domain.model;

import br.com.certvision.domain.enums.Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "certificates")
public class Certificate {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type")
    private Type type;

    @Column(name = "create_dt", nullable = false)
    private LocalDateTime create_dt;

    @Column(name = "expiration_dt", nullable = false)
    private LocalDateTime expiration_dt;

    @Column(name = "active", nullable = false)
    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDateTime getCreate_dt() {
        return create_dt;
    }

    public void setCreate_dt(LocalDateTime create_dt) {
        this.create_dt = create_dt;
    }

    public LocalDateTime getExpiration_dt() {
        return expiration_dt;
    }

    public void setExpiration_dt(LocalDateTime expiration_dt) {
        this.expiration_dt = expiration_dt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
