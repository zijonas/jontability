package org.jonas.jontability.business.mapper;

import org.jonas.jontability.business.dto.AccountDto;
import org.jonas.jontability.persistence.entities.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface AccountMapper extends BasicMapper<AccountEntity, AccountDto> {
	AccountMapper instance = Mappers.getMapper(AccountMapper.class);
}
