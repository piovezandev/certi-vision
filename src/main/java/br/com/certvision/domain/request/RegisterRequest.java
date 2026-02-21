package br.com.certvision.domain.request;

public record RegisterRequest(String fullName, String email, String password, String companyName, String role) {
}
