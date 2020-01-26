package org.jonas.jontability.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jonas.jontability.types.AccountType;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Getter @Setter
@ToString
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private AccountType type;
}
