package org.jonas.jontability.dto;

import lombok.Data;
import org.jonas.jontability.types.AccountType;

@Data
public class AccountDto {
    private Integer id;
    private String name;
    private AccountType type;
}
