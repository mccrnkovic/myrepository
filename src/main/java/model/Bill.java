package model;

import lombok.Data;

import java.util.Date;

@Data
public class Bill {
    private Integer id;
    private User buyer;
    private User seller;
    private Double price;
    private Boolean paid;
    private Date whenPaid;
    private Date issued;
}
