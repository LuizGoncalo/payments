package br.com.luizgoncalo.paymentuser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Usuario n�o cadastrado!")
public class UserNotFoundException extends Exception {

}
