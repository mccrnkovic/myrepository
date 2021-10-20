package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Entity
public class Transaction {
    @Id
    private Integer id;

    @OneToOne
    private BankAccount payee;

    @OneToOne
    private BankAccount payer;

    private Date date;
    private Double amount;
}
