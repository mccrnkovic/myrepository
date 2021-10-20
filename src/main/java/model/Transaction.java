package model;

import lombok.Data;

import java.util.Date;

@Data
public class Transaction {
    private String id;
    private BankAccount payee;
    private BankAccount payer;
    private Date date;
    private Double amount;
}
