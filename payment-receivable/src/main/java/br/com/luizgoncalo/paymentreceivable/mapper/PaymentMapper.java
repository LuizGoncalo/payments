package br.com.luizgoncalo.paymentreceivable.mapper;

import br.com.luizgoncalo.paymentreceivable.domain.PaymentReceivableEntity;
import br.com.luizgoncalo.paymentreceivable.domain.ReceivableStatusEnum;
import br.com.luizgoncalo.paymentreceivable.domain.request.ReceivableRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    default PaymentReceivableEntity receivableRequestToReceivableEntity (ReceivableRequest receivableRequest){
        PaymentReceivableEntity receivableEntity = new PaymentReceivableEntity();
        receivableEntity.setPaymentIdentification(receivableEntity.getPaymentIdentification());
        receivableEntity.setStatus(ReceivableStatusEnum.PENDING);

        return receivableEntity;
    }

}
