package edu.tcu.cs.monnigmeteorite.model;

import jakarta.persistence.*;

@Entity
public class Subsample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meteorite_sample_id", nullable = false)
    private MeteoriteSample meteoriteSample;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MeteoriteSample getMeteoriteSample() {
        return meteoriteSample;
    }

    public void setMeteoriteSample(MeteoriteSample meteoriteSample) {
        this.meteoriteSample = meteoriteSample;
    }
}

