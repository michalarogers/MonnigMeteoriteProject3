package edu.tcu.cs.monnigmeteorite.repository;

import edu.tcu.cs.monnigmeteorite.model.Subsample;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubsampleRepository extends JpaRepository<Subsample, Long> {
    List<Subsample> findByMeteoriteSampleId(Long meteoriteSampleId);
}
