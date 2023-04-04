package model;

import java.util.List;

public class Hospital {
   private long id;
   private String name;
   private String address;
   private List<Doctor> doctors;
   private List<Patient>patients;

    public Hospital(long id, String name, String address, List<Doctor> doctors, List<Patient> patients) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.doctors = doctors;
        this.patients = patients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", doctors=" + doctors +
                ", patients=" + patients +
                '}';
    }
}
