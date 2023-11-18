package com.betrybe.agrix.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Crop.
 */
@Repository
public interface CropRepository extends JpaRepository<CropRepository, Long> {
}
