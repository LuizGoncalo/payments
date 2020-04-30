package br.com.luizgoncalo.paymentreceivable.mapper;

import br.com.luizgoncalo.paymentreceivable.domain.PaymentReceivableEntity;
import br.com.luizgoncalo.paymentreceivable.domain.request.UserRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserRequest paymentEntityToPaymentRequest(final PaymentReceivableEntity receivableEntity);

}
