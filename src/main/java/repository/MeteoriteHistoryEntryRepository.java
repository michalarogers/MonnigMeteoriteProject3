package repository;

import model.MeteoriteHistoryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MeteoriteHistoryEntryRepository extends JpaRepository<MeteoriteHistoryEntry, Long> {
    List<MeteoriteHistoryEntry> findByMeteoriteSampleId(Long meteoriteSampleId);
}
