package org.jonas.jontability.business.impl;

import org.jonas.jontability.Mapper.AccountMapper;
import org.jonas.jontability.business.IBasicService;
import org.jonas.jontability.dto.AccountDto;
import org.jonas.jontability.persistence.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService implements IBasicService<AccountDto> {

    @Autowired
    private AccountRepository accountRepository;
    
    @Override
    public Optional<List<AccountDto>> getAll() {

        return Optional.of(accountRepository.findAll().stream()
                .map(AccountMapper.instance::toDto)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<AccountDto> get(Integer id) {
        return Optional.of(AccountMapper.instance.toDto(accountRepository.findById(id).orElse(null)));
    }

    @Override
    public AccountDto persist(AccountDto accountDto) {
        return AccountMapper.instance.toDto(
                accountRepository.save(
                        AccountMapper.instance.toEntity(accountDto)
                )
        );
    }

    @Override
    public void delete(Integer id) {
        accountRepository.deleteById(id);
    }
}
