package org.jonas.jontability.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bill")
@Getter @Setter
@ToString
public class BillEntity implements BasicEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private Integer id;

    @Column(name = "category_id", insertable = false, updatable = false)
    private Integer categoryId;

    @JoinColumn(name = "category_id")
    @OneToOne(cascade = CascadeType.ALL)
    private CategoryEntity categoryEntity;

    @Column(name = "account_id", insertable = false, updatable = false)
    private Integer accountId;

    @JoinColumn(name = "account_id")
    @OneToOne(cascade = CascadeType.ALL)
    private AccountEntity accountEntity;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @Column(name = "value")
    private Double value;
}
