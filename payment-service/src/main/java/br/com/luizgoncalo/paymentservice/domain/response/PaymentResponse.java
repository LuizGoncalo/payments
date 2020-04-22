package br.com.luizgoncalo.paymentservice.domain.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class PaymentResponse {

    private Long paymentIdentification;

    private BigDecimal value;

    private String status;

}

