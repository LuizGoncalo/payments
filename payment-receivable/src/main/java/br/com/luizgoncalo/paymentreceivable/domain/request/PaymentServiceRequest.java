package br.com.luizgoncalo.paymentreceivable.domain.request;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class PaymentServiceRequest {

    private Long paymentIdentification;

    private BigDecimal value;

    private String cpf;

}
