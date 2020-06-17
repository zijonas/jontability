package org.jonas.jontability.persistence;

import org.jonas.jontability.persistence.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
}
