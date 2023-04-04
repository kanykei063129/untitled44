package service;

import java.util.List;

public interface GenericService<T> {
    List<T>addHospital(T t);
    List<T> getAll();
}
