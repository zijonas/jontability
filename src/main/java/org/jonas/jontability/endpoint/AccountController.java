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
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<AccountDto>> getAll() {
        return ResponseEntity.of(accountService.getAll());
    }

    @PostMapping(value="/account")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AccountDto addAccount(@RequestBody AccountDto accountDto) {
        System.out.println(accountDto);
        return accountService.persist(accountDto);
    }


    @DeleteMapping(value="/account/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void delete(@PathVariable Integer id) {
        try {
            accountService.delete(id);
        } catch (Exception as) {
            as.printStackTrace();
        }
    }
}
