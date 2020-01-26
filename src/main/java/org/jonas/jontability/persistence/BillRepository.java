package org.jonas.jontability.persistence;

import org.jonas.jontability.entities.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<BillEntity, Integer> {
}
