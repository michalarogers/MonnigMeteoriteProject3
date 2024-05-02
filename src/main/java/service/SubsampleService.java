package service;

import model.Subsample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SubsampleRepository;

import java.util.List;

@Service
public class SubsampleService {

    @Autowired
    private SubsampleRepository subsampleRepository;

    public Subsample addSubsample(Subsample subsample) {
        return subsampleRepository.save(subsample);
    }

    public Subsample updateSubsample(Subsample subsample) {
        return subsampleRepository.save(subsample);
    }

    public Subsample findSubsampleById(Long id) {
        return subsampleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subsample not found with ID: " + id));
    }

    public List<Subsample> findSubsamplesByMeteoriteSampleId(Long meteoriteSampleId) {
        return subsampleRepository.findByMeteoriteSampleId(meteoriteSampleId);
    }

    public void deleteSubsample(Long id) {
        subsampleRepository.deleteById(id);
    }

    public List<Subsample> findAllSubsamples() {
        return subsampleRepository.findAll();
    }
}
