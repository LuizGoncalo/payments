package br.com.luizgoncalo.paymentreceivable.mapper;

import br.com.luizgoncalo.paymentreceivable.domain.request.ReceivableRequest;
import br.com.luizgoncalo.paymentreceivable.domain.request.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "cpf", source = "paymentRquest.getCpf")
    })
    UserRequest requestToUserEntity(ReceivableRequest request);

}
