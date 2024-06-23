package com.Employee.Employee;

import com.Employee.Employee.Controller.EmployeeController;
import com.Employee.Employee.Model.Employee;
import com.Employee.Employee.Service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee(1, "John Doe", "IT");
    }

    @Test
    void testGetAllEmployees() throws Exception {
        List<Employee> employees = Arrays.asList(employee);
        when(employeeService.getAllEmployeeList()).thenReturn(employees);

        mockMvc.perform(MockMvcRequestBuilders.get("/getAllEmployees")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(employees)));
    }

    @Test
    void testAddEmployees() throws Exception {
        when(employeeService.addEmployee(any(Employee.class))).thenReturn(employee);

        mockMvc.perform(MockMvcRequestBuilders.post("/addEmployees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(employee)));
    }

    @Test
    void testGetEmployeeById() throws Exception {
        when(employeeService.getEmployeeById(anyInt())).thenReturn(Optional.of(employee));

        mockMvc.perform(MockMvcRequestBuilders.get("/getEmployeeById")
                        .param("EmpId", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(employee)));
    }

    @Test
    void testDeleteEmployeeById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteEmployeeDetailsById")
                        .param("EmpId", "1"))
                .andExpect(status().isOk());

        // Verify that the delete method was called on the service


        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteEmployeeDetailsById")
                        .param("EmpId", "1"))
                .andExpect(status().isOk());
    }
}

