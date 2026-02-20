package br.com.certvision.domain.util;

import br.com.certvision.exceptions.CertificateException;

import javax.naming.InvalidNameException;
import javax.naming.ldap.LdapName;
import java.security.cert.X509Certificate;
import java.util.Date;

import static br.com.certvision.domain.enums.IssueEnum.*;

public class CertificateUtils {

    private static final String NO_CERT_MESSAGE = "Não faz parte do certificado";

    public static boolean isCertificateExpired(X509Certificate cert) {
        return new Date().after(cert.getNotAfter());
    }

    public static String extractCommonName(X509Certificate certificate) {
        String certFullName = certificate.getSubjectX500Principal().getName();
        try {
            LdapName ldapDN = new LdapName(certFullName);
            return ldapDN.getRdns()
                    .stream()
                    .filter(rdn -> rdn.getType().equalsIgnoreCase(CN.getIssueName()))
                    .map(rdn -> rdn.getValue().toString())
                    .findFirst()
                    .orElse(NO_CERT_MESSAGE);
        } catch (InvalidNameException error) {
            throw new CertificateException("Erro ao extrair 'CN' do certificado: ", error);
        }
    }

    public static String extractOrganization(X509Certificate certificate) {
        String certFullName = certificate.getSubjectX500Principal().getName();
        try {
            LdapName ldapDN = new LdapName(certFullName);
            return ldapDN.getRdns()
                    .stream()
                    .filter(rdn -> rdn.getType().equalsIgnoreCase(O.getIssueName()))
                    .map(rdn -> rdn.getValue().toString())
                    .findFirst()
                    .orElse(NO_CERT_MESSAGE);
        } catch (InvalidNameException error) {
            throw new CertificateException("Erro ao extrair 'O' do certificado: ", error);
        }
    }

    public static String extractOrganizationUnit(X509Certificate certificate) {
        String certFullName = certificate.getSubjectX500Principal().getName();
        try {
            LdapName ldapDN = new LdapName(certFullName);
            return ldapDN.getRdns()
                    .stream()
                    .filter(rdn -> rdn.getType().equalsIgnoreCase(OU.getIssueName()))
                    .map(rdn -> rdn.getValue().toString())
                    .findFirst()
                    .orElse(NO_CERT_MESSAGE);
        } catch (InvalidNameException error) {
            throw new CertificateException("Erro ao extrair 'UO' do certificado: ", error);
        }
    }
}