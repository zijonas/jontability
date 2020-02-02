package org.jonas.jontability.business.impl;

import org.jonas.jontability.Mapper.BillMapper;
import org.jonas.jontability.business.IBasicService;
import org.jonas.jontability.dto.BillDto;
import org.jonas.jontability.persistence.AccountRepository;
import org.jonas.jontability.persistence.BillRepository;
import org.jonas.jontability.persistence.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BillService implements IBasicService<BillDto> {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Optional<List<BillDto>> getAll() {

        return Optional.of(billRepository.findAll().stream()
                .map(BillMapper.instance::toDto)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<BillDto> get(Integer id) {
        return Optional.of(BillMapper.instance.toDto(billRepository.findById(id).orElse(null)));
    }

    @Override
    public BillDto persist(BillDto billDto) {
        return BillMapper.instance.toDto(
                billRepository.save(
                        BillMapper.instance.toEntity(billDto, categoryRepository, billRepository, accountRepository)
                )
        );
    }

    @Override
    public void delete(Integer id) {
        billRepository.deleteById(id);
    }
}
