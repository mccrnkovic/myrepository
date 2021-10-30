package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Entity
public class Bill {
    @Id
    private Integer id;

    @OneToOne
    private User buyer;
    @OneToOne
    private User seller;

    private Double price;
    private Boolean paid;
    private Date whenPaid;
    private Date issued;
}
