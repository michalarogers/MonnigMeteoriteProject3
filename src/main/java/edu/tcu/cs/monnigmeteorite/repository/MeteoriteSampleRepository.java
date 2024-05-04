package edu.tcu.cs.monnigmeteorite.repository;

import edu.tcu.cs.monnigmeteorite.model.MeteoriteSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeteoriteSampleRepository extends JpaRepository<MeteoriteSample, String>, JpaSpecificationExecutor<MeteoriteSample> {
}

