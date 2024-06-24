package rw.ac.rca.springsecurity1.exceptions;

public class JwtVerificationException extends RuntimeException{
    public JwtVerificationException(){}
    public JwtVerificationException (String message,Throwable cause){
        super(message,cause);
    }
}
