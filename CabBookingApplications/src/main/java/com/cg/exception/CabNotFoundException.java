package com.cg.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason="Cab Not Found Exception")
public class CabNotFoundException extends Exception{

}
