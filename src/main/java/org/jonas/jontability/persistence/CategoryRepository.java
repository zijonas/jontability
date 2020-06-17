package org.jonas.jontability.persistence;

import org.jonas.jontability.persistence.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
