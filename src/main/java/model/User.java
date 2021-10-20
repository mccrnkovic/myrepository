package model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String hq;
    private Date founded;

    @OneToOne
    private BankAccount bankAccount;

    @OneToMany
    private ArrayList<User> partners;

}
