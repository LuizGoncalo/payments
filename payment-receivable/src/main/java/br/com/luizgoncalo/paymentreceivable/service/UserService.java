package br.com.luizgoncalo.paymentreceivable.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "paymentUser", url = "http://localHost:8082")
public interface UserService {

    @GetMapping("{cpf}")
    public HttpStatus verifyUser(@PathVariable final String cpf);

}
