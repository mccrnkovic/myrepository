package model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private BankAccount payee;

    @OneToOne
    private BankAccount payer;

    private Date date;
    private Double amount;
}
