package com.Employee.Employee.Controller;

import com.Employee.Employee.Model.Employee;
import com.Employee.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

   @Autowired
   EmployeeService EmpService;

   @GetMapping("/")
   public String Login(){
       return "Login to view Employees";
   }

   @GetMapping("/getAllEmployees")
   public List<Employee> getAllEmployee(){
       return EmpService.getAllEmployeeList();
   }

   @PostMapping("/addEmployees")
   public Employee addEmployees(@RequestBody Employee e){
       return EmpService.addEmployee(e);
   }
    @GetMapping("/getEmployeeById")
   public Optional<Employee> getEmployeeDetailsById(@RequestParam Integer EmpId){
       return EmpService.getEmployeeById(EmpId);
   }
   @DeleteMapping("/deleteEmployeeDetailsById")
   public void deleteEmployeeDetailsById(@RequestParam Integer EmpId){
       EmpService.deleteEmployeeById(EmpId);
   }





}
