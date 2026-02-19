package br.com.piovezan.certvision.request;

public record RegisterRequest(String fullName, String email, String password, String companyName, String role) {
}
