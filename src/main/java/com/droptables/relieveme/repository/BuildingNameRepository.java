package com.droptables.relieveme.repository;

import com.droptables.relieveme.domain.BuildingName;
import com.droptables.relieveme.domain.key.BuildingNameKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingNameRepository extends JpaRepository<BuildingName, BuildingNameKey> {

    /**
     * Get the BuildingName in table building_name given a name.
     * Spring parses the method name as a SQL query.
     *
     * @param name - non-null argument; case insensitive
     * @return the BuildingName entry where name.equals(given name)
     */
    BuildingName findByBuildingNameKeyNameIgnoreCase(String name);
}
