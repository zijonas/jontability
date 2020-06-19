package org.jonas.jontability.persistence;

import org.jonas.jontability.persistence.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IPostRepository extends JpaRepository<PostEntity, Integer> {

	List<PostEntity> findByDateGreaterThanEqualAndDateLessThanEqual(LocalDate dateStart, LocalDate dateEnd);

	@Query(value = "select DISTINCT year(date) from PostEntity")
	List<Integer> distinctYears();

	@Query(value = "select month(date), SUM(value) from PostEntity where year(date) = ?1 group by month(date)")
	List<Object[]> sumPerMonthByYear(int year);
}
