package br.com.luizgoncalo.paymentuser.mapper;

import br.com.luizgoncalo.paymentuser.domain.UserEntity;
import br.com.luizgoncalo.paymentuser.domain.reponse.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    UserResponse userEntityToUserResponse(UserEntity userEntity);

}
