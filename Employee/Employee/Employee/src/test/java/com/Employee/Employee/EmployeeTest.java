package com.Employee.Employee;



import com.Employee.Employee.Model.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeTest {

    @Test
    public void testEmployeeConstructorAndGetters() {
        Employee employee = new Employee(1, "John Doe", "Engineering");

        assertNotNull(employee);
        assertEquals(1, employee.getId());
        assertEquals("John Doe", employee.getName());
        assertEquals("Engineering", employee.getDept());
    }

    @Test
    public void testEmployeeSetters() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Jane Doe");
        employee.setDept("Marketing");

        assertEquals(1, employee.getId());
        assertEquals("Jane Doe", employee.getName());
        assertEquals("Marketing", employee.getDept());
    }

    @Test
    public void testToString() {
        Employee employee = new Employee(1, "John Doe", "Engineering");

        String expected = "Employee{id=1, name='John Doe', dept='Engineering'}";
        assertEquals(expected, employee.toString());
    }
}

