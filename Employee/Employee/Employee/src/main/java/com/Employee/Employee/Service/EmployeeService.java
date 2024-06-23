package com.Employee.Employee.Service;

import com.Employee.Employee.Model.Employee;
import com.Employee.Employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repo;

    //to get all employee details
    public List<Employee> getAllEmployeeList(){
        return repo.findAll();
    }

    //create

    public Employee addEmployee(Employee e){
        return repo.save(e);
    }

    //retrive
    public Optional<Employee> getEmployeeById(Integer Eid){
        return repo.findById(Eid);
    }

    //delete
    public void deleteEmployeeById(Integer Eid){
       repo.deleteById(Eid);
    }

    //update






}
