package org.jonas.jontability.api.endpoint;

import org.jonas.jontability.business.dto.AccountDto;
import org.jonas.jontability.business.impl.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/account")
    public ResponseEntity<List<AccountDto>> getAll() {
        return ResponseEntity.of(accountService.getAll());
    }

    @PostMapping(value = "/account")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AccountDto addAccount(@RequestBody AccountDto accountDto) {
        return accountService.persist(accountDto);
    }


    @DeleteMapping(value = "/account/{id}")
    public void delete(@PathVariable Integer id) {
        try {
            accountService.delete(id);
        } catch (Exception as) {
            as.printStackTrace();
        }
    }
}
