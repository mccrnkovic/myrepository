package model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "BankAccount")
public class BankAccount {
    @Id
    private String iban;

    private Double balance;

    @OneToMany
    private List<Transaction> transactions = new ArrayList<Transaction>();
}