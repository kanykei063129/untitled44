package dao;

import model.Doctor;
import model.Hospital;
import model.Patient;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
     private List<Doctor> doctors=new ArrayList<>();
    private List<Patient>patients=new ArrayList<>();
    private List<Hospital>hospitals=new ArrayList<>();

    public DataBase(List<Doctor> doctors, List<Patient> patients, List<Hospital> hospitals) {
        this.doctors = doctors;
        this.patients = patients;
        this.hospitals = hospitals;
    }
    public DataBase(){

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

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    @Override
    public String toString() {
        return "DataBase{" +
                "doctors=" + doctors +
                ", patients=" + patients +
                ", hospitals=" + hospitals +
                '}';
    }
}
