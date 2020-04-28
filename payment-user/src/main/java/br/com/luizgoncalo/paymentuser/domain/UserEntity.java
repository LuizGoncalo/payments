package br.com.luizgoncalo.paymentuser.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

@Data
@Entity
@Table(name = "payment_user")
public class UserEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "user_desc")
    private String name;

    @Column(name = "cpf")
    private String cpf;

    @Column(name="active")
    private Boolean active;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

}
