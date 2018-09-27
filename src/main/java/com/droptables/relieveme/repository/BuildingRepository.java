package com.droptables.relieveme.repository;

import com.droptables.relieveme.domain.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, String> {

    List<Building> findByName(String name);

    List<Building> findByAbbreviation(String abbreviation);

    List<Building> findByRegion(String region);
}