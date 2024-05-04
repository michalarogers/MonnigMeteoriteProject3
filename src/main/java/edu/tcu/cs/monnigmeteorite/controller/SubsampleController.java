package edu.tcu.cs.monnigmeteorite.controller;

import edu.tcu.cs.monnigmeteorite.model.Subsample;
import edu.tcu.cs.monnigmeteorite.service.SubsampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subsamples")
public class SubsampleController {

    @Autowired
    private SubsampleService service;

    @GetMapping
    public ResponseEntity<List<Subsample>> getAllSubsamples() {
        return ResponseEntity.ok(service.findAllSubsamples());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subsample> getSubsampleById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findSubsampleById(id));
    }

    @GetMapping("/related/{meteoriteSampleId}")
    public ResponseEntity<List<Subsample>> getRelatedSubsamples(@PathVariable Long meteoriteSampleId) {
        List<Subsample> relatedSubsamples = service.findSubsamplesByMeteoriteSampleId(meteoriteSampleId);
        if (relatedSubsamples.isEmpty()) {
            return ResponseEntity.noContent().build(); // or ResponseEntity.notFound() depending on expected behavior
        }
        return ResponseEntity.ok(relatedSubsamples);
    }

    @PostMapping
    public ResponseEntity<Subsample> createSubsample(@RequestBody Subsample subsample) {
        return ResponseEntity.ok(service.addSubsample(subsample));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subsample> updateSubsample(@PathVariable Long id, @RequestBody Subsample subsample) {
        subsample.setId(id);
        return ResponseEntity.ok(service.updateSubsample(subsample));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubsample(@PathVariable Long id) {
        service.deleteSubsample(id);
        return ResponseEntity.ok().build();
    }
}
