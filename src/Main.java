import enums.Gender;
import model.Doctor;
import model.Hospital;
import model.Patient;
import service.impl.ServiceImpl1;
import service.impl.ServiceImpl2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
       //жаны пакет тузунуз - model, service, dao, enums
        //model пакетине класстарды тузунуз.
        //Класстар: Hospital, Doctor, Patient
        //Hospital классынын свойствалары: id, name, address, List<Doctor>doctors, List<Patient>patients
        //Doctor классынын свойствалары: id, firstName,lastName, email, List<Patient>patients,gender
        //Patient классынын свойствалары: id, firstName,lastName, phoneNumber,gender,age
        //service пакетине ар бир класска тиешелуу жана бир generic интерфейс тузуп, томонку методдорду жазыныз:
        //  1. - GenericService:
        //List<T>addHospital(T t);
        //List<T>getAll();
        //- HospitalService:
        //List<Hospital>addHospitals(List<Hospital> hospitals);
        //Hospital getHospitalById(Long id);
        //void updateHospital(Long id, Hospital hospital);
        //List<Hospital>sortHospitalByName(String sort);//Stream menen
        //  3. - DoctorService:
        //Doctor getDoctorById(Long id);//Stream
        //List<Doctor> filterByGender(String gender);//Stream
        //-PatientService
        // - List<Patient>addPatient(List<Patient>patients);
        //Patient getPatientByfirstName(String name);//stream
        // - void groupingByGender();//Stream
        //List<Patient>filterByAge();//30 dan oido pasientter chyksyn
        //Реализацияларын impl класстарда кылабыз. Класстар экиден интерфейсти implement кылышат
        //Методдорду озгортууго болбойт, условияда кандай берилсе ошол бойдон иштегиле!
        ServiceImpl1 serviceImpl1 = new ServiceImpl1();
        ServiceImpl2 serviceImpl2 = new ServiceImpl2();

        Patient patient = new Patient(1L,"Malik","Turatbek uulu",706050119, Gender.M,18);
        Patient patient1 = new Patient(2L,"Manas","Ruslan uulu",705050118,Gender.M,20);
        Patient patient2 = new Patient(3L,"Aizat","Duicheeva",770563489,Gender.F,18);
        List<Patient>patients = new ArrayList<>(List.of(patient,patient1,patient2));

        Doctor doctor = new Doctor(1L,"Davran","Joldoshbaev","davran@gmail.com",patients,Gender.M);
        Doctor doctor1 = new Doctor(2L,"Adilet","Islambek uulu","adilet@gmail.com",patients,Gender.M);
        Doctor doctor2 = new Doctor(3L,"Kanykei","Akjoltoi kyzy","kanykei@gmail.com",patients,Gender.F);
        List<Doctor>doctors = new ArrayList<>(List.of(doctor,doctor1,doctor2));

        Hospital hospital = new Hospital(1L,"Hospital","Vostoc 5",doctors,patients);
        Hospital hospital1 = new Hospital(2L,"Aibolit","Alamedin",doctors,patients);
        List<Hospital>hospitals = new ArrayList<>(List.of(hospital,hospital1));

        System.out.println(serviceImpl1.addHospital(hospital));
        serviceImpl1.getAll();

        System.out.println(serviceImpl1.addHospitals(hospitals));
        System.out.println(serviceImpl1.getHospitalById(1L));
        serviceImpl1.updateHospital(2L,hospital);
        System.out.println(serviceImpl1.sortHospitalByName("Frunze"));

        System.out.println(serviceImpl2.getDoctorById(1L));
        serviceImpl2.filterByGender("M");

        serviceImpl2.addPatient(patients);
        System.out.println(serviceImpl2.getPatientByfirstName("Tursunai"));
        serviceImpl2.groupingByGender();
        serviceImpl2.filterByAge();

    }
}