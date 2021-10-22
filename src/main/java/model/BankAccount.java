package model;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;

@Data
@Entity(name = "BankAccount")
public class BankAccount {
    @Id
    private String iban;

    private Double balance;

    @OneToMany
    private ArrayList<Transaction> transactions;
}