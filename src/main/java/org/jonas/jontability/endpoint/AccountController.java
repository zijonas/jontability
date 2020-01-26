package org.jonas.jontability.endpoint;

import org.jonas.jontability.business.impl.AccountService;
import org.jonas.jontability.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value="/account")
    public ResponseEntity<List<AccountDto>> getAll() {
        return ResponseEntity.of(accountService.getAll());
    }

    @PostMapping(value="/account")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AccountDto addAccount(@RequestBody AccountDto accountDto) {
        System.out.println(accountDto);
        return accountService.persist(accountDto);
    }

}
