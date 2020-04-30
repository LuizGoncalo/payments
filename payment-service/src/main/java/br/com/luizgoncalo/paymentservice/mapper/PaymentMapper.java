package br.com.luizgoncalo.paymentservice.mapper;

import br.com.luizgoncalo.paymentservice.domain.PaymentEntity;
import br.com.luizgoncalo.paymentservice.domain.PaymentStatusEnum;
import br.com.luizgoncalo.paymentservice.domain.request.PaymentRequest;
import br.com.luizgoncalo.paymentservice.domain.response.PaymentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentResponse paymentEntityToPaymentResponse(PaymentEntity paymentEntity);

    default PaymentEntity paymentRequestToPaymentEntity(PaymentRequest paymentRequest){
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setUserCpf(paymentRequest.getCpf());
        paymentEntity.setPaymentIdentification(paymentRequest.getPaymentIdentification());
        paymentEntity.setValue(paymentRequest.getValue());
        paymentEntity.setStatus(PaymentStatusEnum.PROCESSED);

        return paymentEntity;
    }
}
