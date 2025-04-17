package gp2.TaskManagement.TaskService.Entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class Candidate {

    private String name;

    private String sex;
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(unique = true)
    private String email;

    private String phone;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate birthdate;


    private String Nationality;

    private String birthplace;

    public String getNationality() {
        return Nationality;
    }

    public Candidate setNationality(String nationality) {
        Nationality = nationality;
        return this;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public Candidate setBirthplace(String birthplace) {
        this.birthplace = birthplace;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public Candidate setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getAddress() {
        return Address;
    }

    public Candidate setAddress(String address) {
        Address = address;
        return this;
    }

    private String region;

    private String Address;

    private String cni;


    public enum Status {
        NEW, QUALIFIED, NEGOTIATION, STUDENT
    }

    public String getSex() {
        return sex;
    }

    public Candidate setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }


    public String getName() {
        return name;
    }

    public Candidate setName(String name) {
        this.name = name;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Candidate setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Candidate setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Candidate setPhone(String phone) {
        this.phone = phone;
        return this;
    }

}
