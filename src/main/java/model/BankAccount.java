package model;

import lombok.Data;

@Data
public class BankAccount {
    private String iban;
    private Double balance;
}