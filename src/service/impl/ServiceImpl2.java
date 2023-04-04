package service.impl;

import dao.DataBase;
import enums.Gender;
import model.Doctor;
import model.Hospital;
import model.Patient;
import service.DoctorService;
import service.PatientService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ServiceImpl2 implements DoctorService, PatientService {
    DataBase dataBase = new DataBase();
    @Override
    public Doctor getDoctorById(Long id) {
        for (Doctor d:dataBase.getDoctors()) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    @Override
    public List<Doctor> filterByGender(String gender) {
            List<Doctor>boys = dataBase.getDoctors().stream().filter(s -> s.getGender().equals(Gender.M)).toList();
            List<Doctor> girls = dataBase.getDoctors().stream().filter(s -> s.getGender().equals(Gender.F)).toList();
            System.out.println("boys\n"+boys);
            System.out.println("gris\n"+girls);
            return null;
    }

    @Override
    public List<Patient> addPatient(List<Patient> patients) {
        dataBase.getPatients().add((Patient) patients);
        return patients;
    }

    @Override
    public Patient getPatientByfirstName(String name) {
        for (Patient p:dataBase.getPatients()) {
          if (p.getFirstName().equalsIgnoreCase(name)) {
              return p;
          }
        }
        return null;
    }

    @Override
    public void groupingByGender() {
        List<Doctor>boys = dataBase.getDoctors().stream().filter(s -> s.getGender().equals(Gender.M)).toList();
        List<Doctor> girls = dataBase.getDoctors().stream().filter(s -> s.getGender().equals(Gender.F)).toList();
        System.out.println("boys\n"+boys);
        System.out.println("gris\n"+girls);
    }

    @Override
    public List<Patient> filterByAge() {
        dataBase.getPatients().stream().sorted(Comparator.comparing(Patient::getAge)).forEach(System.out::println);
        return (List<Patient>) dataBase.getPatients();
    }
}
