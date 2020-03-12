package org.jonas.jontability.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter
@ToString
@Entity
@Table(name = "authority")
public class AuthorityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private Long id;

    @Column(name = "username", insertable = false, updatable = false)
    private String username;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private UserDataEntity userDataEntity;

    @Column(name = "role")
    private String role;
}


