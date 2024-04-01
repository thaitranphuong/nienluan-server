package com.luanvan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.luanvan.entity.WarehouseEntity;

public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Long>{
	@Query(value = "SELECT * FROM warehouses c WHERE c.name LIKE %?1%", nativeQuery = true)
	List<WarehouseEntity> findAll(String name);
	
	@Query(value = "SELECT * FROM warehouses c LIMIT ?2 OFFSET ?1", nativeQuery = true)
	List<WarehouseEntity> findAll(int page, int limit);
	
	@Query(value = "SELECT * FROM warehouses c WHERE c.name LIKE %?1% LIMIT ?3 OFFSET ?2", nativeQuery = true)
	List<WarehouseEntity> findAll(String name, int page, int limit);
}
