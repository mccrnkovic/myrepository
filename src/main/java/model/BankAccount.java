package model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "BankAccount")
public class BankAccount {
    @Id
    @NotBlank(message="Please provide an IBAN")
    private String iban;

    @NotNull(message = "Please provide a balance")
    private Double balance;

    @OneToMany
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public static class BankAccountBuilder {
        String iban;
        Double balance;

        public BankAccountBuilder(String iban) {
            this.iban = iban;
        }

        public BankAccount build() {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setIban(this.iban);
            bankAccount.setBalance(this.balance);
            return bankAccount;
        }

        public void setIban(String iban) {
            this.iban = iban;
        }

        public void setBalance(Double balance) {
            this.balance = balance;
        }
    }
}