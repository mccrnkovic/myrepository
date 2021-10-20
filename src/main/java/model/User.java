package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Date;

@Data
@Entity
public class User {
    @Id
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
