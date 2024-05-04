package edu.tcu.cs.monnigmeteorite.model;

import jakarta.persistence.*;

@Entity
@Table(name = "meteorite_samples")
public class MeteoriteSample {
    @Id
    private String monnigNumber; // Unique identifier for the meteorite sample
    private String name;
    private String classType;
    @Column(name = "\"group\"")
    private String group;
    private String clan;
    private String country;
    private String location;
    private String foundOrFall;
    private String sampleType;
    private Double totalKnownWeight;
    private Double sampleWeight;
    private Integer yearFound;
    private Boolean isEducationalSpecimen;
    private Boolean isRepositorySpecimen;

    @Column(name = "is_active")
    private boolean isActive = true;  // All samples are active by default.

    // Constructors, getters, and setters

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    // Constructors
    public MeteoriteSample() {
    }

    // Getters and Setters
    public String getMonnigNumber() {

        return monnigNumber;
    }

    public void setMonnigNumber(String monnigNumber) {

        this.monnigNumber = monnigNumber;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getClassType() {

        return classType;
    }

    public void setClassType(String classType) {

        this.classType = classType;
    }

    public String getGroup() {

        return group;
    }

    public void setGroup(String group) {

        this.group = group;
    }

    public String getClan() {

        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public String getFoundOrFall() {

        return foundOrFall;
    }

    public void setFoundOrFall(String foundOrFall) {

        this.foundOrFall = foundOrFall;
    }

    public String getSampleType() {

        return sampleType;
    }

    public void setSampleType(String sampleType) {

        this.sampleType = sampleType;
    }

    public Double getTotalKnownWeight() {

        return totalKnownWeight;
    }

    public void setTotalKnownWeight(Double totalKnownWeight) {

        this.totalKnownWeight = totalKnownWeight;
    }

    public Double getSampleWeight() {

        return sampleWeight;
    }

    public void setSampleWeight(Double sampleWeight) {

        this.sampleWeight = sampleWeight;
    }

    public Integer getYearFound() {

        return yearFound;
    }

    public void setYearFound(Integer yearFound) {

        this.yearFound = yearFound;
    }

    public Boolean getIsEducationalSpecimen() {

        return isEducationalSpecimen;
    }

    public void setIsEducationalSpecimen(Boolean isEducationalSpecimen) {
        this.isEducationalSpecimen = isEducationalSpecimen;
    }

    public Boolean getIsRepositorySpecimen() {

        return isRepositorySpecimen;
    }

    public void setIsRepositorySpecimen(Boolean isRepositorySpecimen) {
        this.isRepositorySpecimen = isRepositorySpecimen;
    }
}
