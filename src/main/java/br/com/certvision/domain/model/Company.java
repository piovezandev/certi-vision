package br.com.certvision.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "company")
public class Company {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "company_id")
    private Long id;

    @Column(name = "document", length = 20)
    private String cnpj;

    @Column(name = "name")
    private String name;

    @Column(name = "max_endpoints")
    private Integer max_endpoints;

    @Column(name = "plan")
    private String plan;

    @Column(name = "status")
    private String status;

    @Column(name = "create_dt")
    private LocalDateTime create_dt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMax_endpoints() {
        return max_endpoints;
    }

    public void setMax_endpoints(Integer max_endpoints) {
        this.max_endpoints = max_endpoints;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreate_dt() {
        return create_dt;
    }

    public void setCreate_dt(LocalDateTime create_dt) {
        this.create_dt = create_dt;
    }
}
