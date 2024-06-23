package com.Employee.Employee;

import com.Employee.Employee.Model.Employee;
import com.Employee.Employee.Repository.EmployeeRepository;
import com.Employee.Employee.Service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee(1, "John Doe", "IT");
    }

    @Test
    void testGetAllEmployeeList() {
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));

        List<Employee> employeeList = employeeService.getAllEmployeeList();

        assertNotNull(employeeList);
        assertEquals(1, employeeList.size());
        assertEquals(employee.getName(), employeeList.get(0).getName());
    }

    @Test
    void testAddEmployee() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee savedEmployee = employeeService.addEmployee(employee);

        assertNotNull(savedEmployee);
        assertEquals(employee.getName(), savedEmployee.getName());
    }

    @Test
    void testGetEmployeeById() {
        when(employeeRepository.findById(anyInt())).thenReturn(Optional.of(employee));

        Optional<Employee> foundEmployee = employeeService.getEmployeeById(1);

        assertTrue(foundEmployee.isPresent());
        assertEquals(employee.getName(), foundEmployee.get().getName());
    }

    @Test
    void testDeleteEmployeeById() {
        doNothing().when(employeeRepository).deleteById(anyInt());

        employeeService.deleteEmployeeById(1);

        verify(employeeRepository, times(1)).deleteById(1);
    }

    // Add a test for the update method once implemented
}

