package com.liverpool.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.liverpool.challenge.entity.FolioEntity;

@Repository
public interface FolioRepository  extends JpaRepository<FolioEntity, Long>{

	public List<FolioEntity> findByFolio(@PathVariable String folio);
}
