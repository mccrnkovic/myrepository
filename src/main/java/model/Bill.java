package model;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
