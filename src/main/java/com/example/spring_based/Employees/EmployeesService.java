package com.example.spring_based.Employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {
    @Autowired
    public EmployeesRepository employeesRepository;
    List<EmployeesEntity> findAll(PageRequest of){return  employeesRepository.findAll();}
    Optional<EmployeesEntity> findById(int id){return employeesRepository.findById(id);}
    void delete(int id){ employeesRepository.deleteById(id);}
    EmployeesEntity save(EmployeesEntity employeesEntity){return employeesRepository.save(employeesEntity);}
}
