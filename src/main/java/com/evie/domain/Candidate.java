package com.evie.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "candidate")
public class Candidate {

    @Id
    private long _Id;
    private String firstName;
    private String middleName;
    private String lastName;
    private int totalYears;
    private List<Skill> skills;
    private Dicipline coreDiscipline;
    private String referrer;
    private long referrredId;

    public long get_Id() {
        return _Id;
    }

    public void set_Id(long _Id) {
        this._Id = _Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTotalYears() {
        return totalYears;
    }

    public void setTotalYears(int totalYears) {
        this.totalYears = totalYears;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Dicipline getCoreDiscipline() {
        return coreDiscipline;
    }

    public void setCoreDiscipline(Dicipline coreDiscipline) {
        this.coreDiscipline = coreDiscipline;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public long getReferrredId() {
        return referrredId;
    }

    public void setReferrredId(long referrredId) {
        this.referrredId = referrredId;
    }
}
