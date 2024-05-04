package edu.tcu.cs.monnigmeteorite.controller;

import edu.tcu.cs.monnigmeteorite.model.MeteoriteSample;
import edu.tcu.cs.monnigmeteorite.service.MeteoriteSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meteoriteSamples")
public class MeteoriteSampleController {

    @Autowired
    private MeteoriteSampleService service;

    @GetMapping("/search")
    public ResponseEntity<List<MeteoriteSample>> searchMeteoriteSamples(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String classType,
            @RequestParam(required = false) String group,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String foundOrFall,
            @RequestParam(defaultValue = "name") String sortProperty, // default sort by name
            @RequestParam(defaultValue = "false") boolean desc // default sort ascending
    ) {
        List<MeteoriteSample> results = service.searchSamples(name, classType, group, country, foundOrFall, sortProperty, desc);
        return ResponseEntity.ok(results);
    }

    @GetMapping
    public ResponseEntity<List<MeteoriteSample>> getAllMeteoriteSamples() {
        return ResponseEntity.ok(service.findAllMeteoriteSamples());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeteoriteSample> getMeteoriteSampleById(@PathVariable String id) {
        MeteoriteSample sample = service.findMeteoriteSampleById(id);
        if (sample != null) {
            return ResponseEntity.ok(sample);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createMeteoriteSample(@RequestBody MeteoriteSample sample) {
        try {
            MeteoriteSample savedSample = service.addMeteoriteSample(sample);
            return ResponseEntity.ok(savedSample);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMeteoriteSample(@PathVariable String id, @RequestBody MeteoriteSample sample) {
        try {
            sample.setMonnigNumber(id); // Ensure correct ID is set
            MeteoriteSample updatedSample = service.updateMeteoriteSample(sample);
            return ResponseEntity.ok(updatedSample);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMeteoriteSample(@PathVariable String id) {
        try {
            service.deleteMeteoriteSample(id);
            return ResponseEntity.ok().build();  // Respond with 200 OK on successful deletion
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());  // Respond with error message if sample not found
        }
    }


}
