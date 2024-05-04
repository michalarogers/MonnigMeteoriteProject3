package edu.tcu.cs.monnigmeteorite.service;

import edu.tcu.cs.monnigmeteorite.model.MeteoriteHistoryEntry;
import edu.tcu.cs.monnigmeteorite.repository.MeteoriteHistoryEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeteoriteHistoryEntryService {

    @Autowired
    private MeteoriteHistoryEntryRepository meteoriteHistoryEntryRepository;

    public MeteoriteHistoryEntry addMeteoriteHistoryEntry(MeteoriteHistoryEntry historyEntry) {
        return meteoriteHistoryEntryRepository.save(historyEntry);
    }

    public MeteoriteHistoryEntry updateMeteoriteHistoryEntry(MeteoriteHistoryEntry historyEntry) {
        return meteoriteHistoryEntryRepository.save(historyEntry);
    }

    public MeteoriteHistoryEntry findMeteoriteHistoryEntryById(Long id) {
        return meteoriteHistoryEntryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Meteorite History Entry not found with ID: " + id));
    }

    public void deleteMeteoriteHistoryEntry(Long id) {
        meteoriteHistoryEntryRepository.deleteById(id);
    }

    public List<MeteoriteHistoryEntry> findAllMeteoriteHistoryEntries() {
        return meteoriteHistoryEntryRepository.findAll();
    }

    public List<MeteoriteHistoryEntry> findHistoryByMeteoriteSampleId(Long meteoriteSampleId) {
        return meteoriteHistoryEntryRepository.findByMeteoriteSampleId(meteoriteSampleId);
    }
}

