package org.jonas.jontability.persistence;

import org.jonas.jontability.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {

	List<PostEntity> findByDateGreaterThanAndDateLessThan(Date dateStart, Date dateEnd);
}
