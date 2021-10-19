package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class User {
    private String id;
    private String name;
    private String hq;
    private Date founded;
    private ArrayList<User> partners;

}
