package br.com.luizgoncalo.paymentservice.domain.response;

import lombok.Data;

@Data
public class PaymentResponse {

    private Long paymentIdentification;

    private String status;

}

