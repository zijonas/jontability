package org.jonas.jontability.persistence.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_data")
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<AuthorityEntity> getAuthority() {
        return authority;
    }

    public void setAuthority(Set<AuthorityEntity> authority) {
        this.authority = authority;
    }
}
