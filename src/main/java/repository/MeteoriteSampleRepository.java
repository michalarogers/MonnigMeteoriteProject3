package repository;

import model.MeteoriteSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeteoriteSampleRepository extends JpaRepository<MeteoriteSample, String>, JpaSpecificationExecutor<MeteoriteSample> {
}
