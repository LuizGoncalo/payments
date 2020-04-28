package br.com.luizgoncalo.paymentuser.resource;

import br.com.luizgoncalo.paymentuser.domain.UserEntity;
import br.com.luizgoncalo.paymentuser.domain.reponse.UserResponse;
import br.com.luizgoncalo.paymentuser.exception.UserNotFoundException;
import br.com.luizgoncalo.paymentuser.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<UserResponse> verifyUser(@PathVariable final String cpf){
        try{
             UserResponse userResponse= userService.verifyUser(cpf);
             log.info("M=verifyUser, I=Dados recuperado com sucesso {}", userResponse);
             return ResponseEntity.status(HttpStatus.OK).body(userResponse);
        } catch (UserNotFoundException e){
            log.error("M=verifyUser, I=Usuario com cpf : {} não encontrado", cpf);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

}
