package model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Boolean admin;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date founded;

    @OneToOne
    private BankAccount bankAccount;

    @OneToMany
    private ArrayList<User> partners;

}
