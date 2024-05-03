package edu.tcu.cs.monnigmeteorite.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Loans implements Serializable {

    @Id
    private Integer id;
    private String loaneeName;
    private String institution;
    private String email;
    private String phone;
    private String address;
    private String loanStartDate;
    private String loanDueDate;
    private String monnigIds;
    //parse it or something
//    private Integer trackingNumber;
    //this is only sometimes needed?
    private String notes;
    private String extraFile;
    private boolean isArchived;
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoaneeName() {
        return loaneeName;
    }

    public void setLoaneeName(String name) {
        this.loaneeName = name;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(String loan_start_date) {
        this.loanStartDate = loan_start_date;
    }

    public String getLoanDueDate() {
        return loanDueDate;
    }

    public void setLoanDueDate(String loan_end_date) {
        this.loanDueDate = loan_end_date;
    }

    public String getMonnigIds() {
        return monnigIds;
    }

    public void setMonnigIds(String monnigIds) {
        this.monnigIds = monnigIds;
    }

//    public Integer getTrackingNumber() {
//        return trackingNumber;
//    }
//
//    public void setTrackingNumber(Integer tracking_number) {
//        this.trackingNumber = tracking_number;
//    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getExtraFile() {
        return extraFile;
    }

    public void setExtraFile(String extra_file) {
        this.extraFile = extra_file;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }
}


