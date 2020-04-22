package br.com.luizgoncalo.paymentuser.resource;

import br.com.luizgoncalo.paymentuser.exception.UserNotFoundException;
import br.com.luizgoncalo.paymentuser.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/payment-user")
public class UserResource {

    @Autowired
    UserService userService;

    @GetMapping("/{cpf}")
    private HttpStatus verifyUser(@PathVariable String cpf){
        try{
            userService.verifyUser(cpf);
            return HttpStatus.OK;
        } catch (UserNotFoundException e){
            log.error("M=verifyUSer, I=Usuario com cpf : {} não encontrado", cpf);
            return HttpStatus.NO_CONTENT;
        }
    }

}
