package br.com.luizgoncalo.paymentuser.service;

import br.com.luizgoncalo.paymentuser.domain.UserEntity;
import br.com.luizgoncalo.paymentuser.domain.reponse.UserResponse;
import br.com.luizgoncalo.paymentuser.exception.UserNotFoundException;
import br.com.luizgoncalo.paymentuser.mapper.UserResponseMapper;
import br.com.luizgoncalo.paymentuser.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserResponseMapper responseMapper;

    public UserResponse verifyUser(final String cpf) throws UserNotFoundException{
        log.info("m=verifyUser, i=Verificando usuario com cpf={}", cpf);

        UserEntity userEntity = userRepository.findUserWithCpf(cpf).orElseThrow(UserNotFoundException::new);

        return responseMapper.userEntityToUserResponse(userEntity);

    }

}
