package br.com.certvision.exceptions;

public class CertficateException extends RuntimeException {

    public CertficateException(String message) {
        super(message);
    }

    public CertficateException(String message, Throwable cause) {
        super(message, cause);
    }
}