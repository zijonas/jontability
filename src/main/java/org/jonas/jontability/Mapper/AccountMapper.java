package org.jonas.jontability.Mapper;

import org.jonas.jontability.dto.AccountDto;
import org.jonas.jontability.entities.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface AccountMapper extends BasicMapper<AccountEntity, AccountDto> {
	AccountMapper instance = Mappers.getMapper(AccountMapper.class);
}
