package edu.tcu.cs.monnigmeteorite.controller;

import edu.tcu.cs.monnigmeteorite.model.MeteoriteHistoryEntry;
import edu.tcu.cs.monnigmeteorite.service.MeteoriteHistoryEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historyEntries")
public class MeteoriteHistoryEntryController {

    @Autowired
    private MeteoriteHistoryEntryService service;

    @GetMapping
    public ResponseEntity<List<MeteoriteHistoryEntry>> getAllHistoryEntries() {
        return ResponseEntity.ok(service.findAllMeteoriteHistoryEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeteoriteHistoryEntry> getHistoryEntryById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findMeteoriteHistoryEntryById(id));
    }

    @PostMapping
    public ResponseEntity<MeteoriteHistoryEntry> createHistoryEntry(@RequestBody MeteoriteHistoryEntry historyEntry) {
        return ResponseEntity.ok(service.addMeteoriteHistoryEntry(historyEntry));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeteoriteHistoryEntry> updateHistoryEntry(@PathVariable Long id, @RequestBody MeteoriteHistoryEntry historyEntry) {
        historyEntry.setId(id);
        return ResponseEntity.ok(service.updateMeteoriteHistoryEntry(historyEntry));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistoryEntry(@PathVariable Long id) {
        service.deleteMeteoriteHistoryEntry(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/bySample/{meteoriteSampleId}")
    public ResponseEntity<List<MeteoriteHistoryEntry>> getHistoryByMeteoriteSampleId(@PathVariable Long meteoriteSampleId) {
        List<MeteoriteHistoryEntry> historyEntries = service.findHistoryByMeteoriteSampleId(meteoriteSampleId);
        if (historyEntries.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(historyEntries);
    }
}

