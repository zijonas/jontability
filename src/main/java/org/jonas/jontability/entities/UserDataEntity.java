package org.jonas.jontability.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter
@ToString
@Table(name = "user_data")
@Entity
public class UserDataEntity {

    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "userDataEntity")
    private Set<AuthorityEntity> authority;
}
