package org.jonas.jontability.persistence.entities;

import javax.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserDataEntity getUserDataEntity() {
        return userDataEntity;
    }

    public void setUserDataEntity(UserDataEntity userDataEntity) {
        this.userDataEntity = userDataEntity;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


