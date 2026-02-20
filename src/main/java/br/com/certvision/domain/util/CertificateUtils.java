package br.com.certvision.domain.util;

import br.com.certvision.exceptions.CertificateException;

import javax.naming.InvalidNameException;
import javax.naming.ldap.LdapName;
import java.security.cert.X509Certificate;
import java.util.Date;

public class CertificateUtils {

    public static boolean isCertificateExpired(X509Certificate cert) {
        return new Date().after(cert.getNotAfter());
    }

    public static String extractCommonName(X509Certificate certificate) {
        String certFullName = certificate.getSubjectX500Principal().getName();
        try {
            LdapName ldapDN = new LdapName(certFullName);
            return ldapDN.getRdns()
                    .stream()
                    .filter(rdn -> rdn.getType().equalsIgnoreCase("CN"))
                    .map(rdn -> rdn.getValue().toString())
                    .findFirst()
                    .orElse(certFullName);
        } catch (InvalidNameException error) {
            throw new CertificateException("Erro ao extrair CN do certificado: ", error);
        }
    }
}