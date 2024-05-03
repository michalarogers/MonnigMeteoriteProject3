package edu.tcu.cs.monnigmeteorite.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class MeteoriteHistoryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date eventDate;

    @Column(nullable = false)
    private String details;

    @ManyToOne
    @JoinColumn(name = "meteorite_sample_id", nullable = false)
    private MeteoriteSample meteoriteSample;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public MeteoriteSample getMeteoriteSample() {
        return meteoriteSample;
    }

    public void setMeteoriteSample(MeteoriteSample meteoriteSample) {
        this.meteoriteSample = meteoriteSample;
    }
}

