package com.OligarchRating.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.OligarchRating.model.Oligarch;

public interface OligarchRepo extends JpaRepository<Oligarch, Long> {

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO Oligarch (id, firstName, lastName, assetsValue) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
	void addNewOligarch(Long id, String firstName, String lastName, Double assetsValue);

	@Query("SELECT u FROM Oligarch u")
	List<Oligarch> getAllOligarchs();

	@Query("SELECT u FROM Oligarch u WHERE u.id = :id")
	Oligarch getOligarchById(@Param("id") long id);

	@Query("SELECT u.id FROM Oligarch u ORDER BY u.assetsValue DESC")
	List<Long> getOligarchListOrderByAssetsValue();

}
