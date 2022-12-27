package com.sara.locationweb.repositories;

import com.sara.locationweb.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
