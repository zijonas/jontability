package org.jonas.jontability.business.dto;

import org.jonas.jontability.business.types.AccountType;

public class AccountDto {
    private Integer id;
    private String name;
    private AccountType type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
}
