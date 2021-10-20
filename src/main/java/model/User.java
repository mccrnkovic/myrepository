package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String hq;
    private Date founded;
    private BankAccount bankAccount;
    private ArrayList<User> partners;

}
