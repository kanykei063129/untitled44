package service.impl;

import dao.DataBase;
import model.Hospital;
import service.GenericService;
import service.HospitalService;

import java.util.Comparator;
import java.util.List;

public class ServiceImpl1 implements GenericService, HospitalService {
    DataBase dataBase = new DataBase();
    @Override
    public List addHospital(Object o) {
        dataBase.getHospitals().add((Hospital) o);
        return List.of(o);
    }

    @Override
    public List getAll() {
        return dataBase.getHospitals();
    }

    @Override
    public List<Hospital> addHospitals(List<Hospital> hospitals) {
        dataBase.getHospitals().add((Hospital) hospitals);
        return hospitals;
    }

    @Override
    public Hospital getHospitalById(Long id) {
        for (Hospital h : dataBase.getHospitals()) {
            if (h.getId() == id) {
                return h;
            }
        }
        return null;
    }

    @Override
    public void updateHospital(Long id, Hospital hospital) {
        for (Hospital h:dataBase.getHospitals()) {
            if (h.getId()==id){
                h.setName(String.valueOf(hospital));
            }
        }
    }

    @Override
    public List<Hospital> sortHospitalByName(String sort) {
        dataBase.getHospitals().stream().sorted(Comparator.comparing(Hospital::getName)).forEach(System.out::println);
        return (List<Hospital>) dataBase.getHospitals();
    }
}
