package br.com.luizgoncalo.paymentuser.service;

import br.com.luizgoncalo.paymentuser.domain.UserEntity;
import br.com.luizgoncalo.paymentuser.exception.UserNotFoundException;
import br.com.luizgoncalo.paymentuser.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public UserEntity verifyUser(String cpf) {
        log.info("m=verifyUser, i=Verificando usuario");

        return userRepository.findUserWithCpf(cpf)
                .orElseThrow(UserNotFoundException::new);

    }

}
