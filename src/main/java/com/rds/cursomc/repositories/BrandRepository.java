package com.rds.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rds.cursomc.domain.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
