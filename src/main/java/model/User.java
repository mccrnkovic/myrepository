package model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;

@Data
@Entity(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "You did not give a name")
    private String name;

    @NotBlank(message = "You did not give an email")
    private String email;

    @NotNull
    @Size(min=4, message = "Password must contain at least 4 characters")
    private String password;

    @NotBlank(message = "You did not give a headquarters")
    private String hq;

    private Boolean admin;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date founded;

    @OneToOne
    @NotNull
    private BankAccount bankAccount;

    @OneToMany
    private ArrayList<User> partners;

}
