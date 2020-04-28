package br.com.luizgoncalo.paymentuser.domain.reponse;

import lombok.Data;

@Data
public class UserResponse {

    private String cpf;

    private Boolean active;

}
