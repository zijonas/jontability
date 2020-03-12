package org.jonas.jontability.persistence;

import org.jonas.jontability.entities.UserDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserDataEntity, String> {

}
