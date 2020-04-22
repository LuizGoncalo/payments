package br.com.luizgoncalo.paymentservice.mapper;

import br.com.luizgoncalo.paymentservice.domain.PaymentEntity;
import br.com.luizgoncalo.paymentservice.domain.PaymentStatusEnum;
import br.com.luizgoncalo.paymentservice.domain.request.PaymentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mappings({
            @Mapping(target = "value", source = ""),
            @Mapping(target = "", dateFormat = "DD/MM/YYYY HH:mm:ss")
    })

    default PaymentEntity paymentRequestToPaymentEntity(PaymentRequest paymentRequest){
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setPaymentIdentification(paymentRequest.getPaymentIdentification());
        paymentEntity.setValue(paymentRequest.getValue());
        paymentEntity.setStatus(PaymentStatusEnum.PENDING);

        return paymentEntity;
    }

}
