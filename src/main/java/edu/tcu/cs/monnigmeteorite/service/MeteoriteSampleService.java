package edu.tcu.cs.monnigmeteorite.service;

import edu.tcu.cs.monnigmeteorite.model.MeteoriteSample;
import edu.tcu.cs.monnigmeteorite.repository.MeteoriteSampleRepository;
import edu.tcu.cs.monnigmeteorite.specification.MeteoriteSampleSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeteoriteSampleService {

    @Autowired
    private MeteoriteSampleRepository meteoriteSampleRepository;

    public List<MeteoriteSample> searchSamples(String name, String classType, String group, String country, String foundOrFall, String sortProperty, boolean desc) {
        Specification<MeteoriteSample> spec = MeteoriteSampleSpecifications.findByCriteria(name, classType, group, country, foundOrFall);
        Sort sort = desc ? Sort.by(sortProperty).descending() : Sort.by(sortProperty).ascending();
        return meteoriteSampleRepository.findAll(spec, sort);
    }


    public MeteoriteSample updateMeteoriteSample(MeteoriteSample sample) {
        if (sample.getMonnigNumber() == null || !meteoriteSampleRepository.existsById(sample.getMonnigNumber())) {
            throw new IllegalArgumentException("Meteorite Sample with ID: " + sample.getMonnigNumber() + " does not exist.");
        }
        // Additional validations can be added here
        return meteoriteSampleRepository.save(sample);
    }


    public MeteoriteSample findMeteoriteSampleById(String id) {
        return meteoriteSampleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Meteorite Sample not found with ID: " + id));
    }

    public MeteoriteSample addMeteoriteSample(MeteoriteSample sample) {
        // Check for duplication
        if (meteoriteSampleRepository.existsById(sample.getMonnigNumber())) {
            throw new IllegalStateException("Meteorite Sample with this Monnig Number already exists.");
        }
        return meteoriteSampleRepository.save(sample);
    }


    public void deleteMeteoriteSample(String id) {
        MeteoriteSample sample = meteoriteSampleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Meteorite Sample not found with ID: " + id));
        sample.setActive(false);  // Soft delete the sample
        meteoriteSampleRepository.save(sample);  // Save the updated sample
    }


    public List<MeteoriteSample> findAllMeteoriteSamples() {
        return meteoriteSampleRepository.findAll();
    }
}

