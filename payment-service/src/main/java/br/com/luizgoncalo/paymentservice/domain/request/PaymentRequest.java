package br.com.luizgoncalo.paymentservice.domain.request;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class PaymentRequest {

    private Long paymentIdentification;

    private BigDecimal value;

    private String cpf;

}
