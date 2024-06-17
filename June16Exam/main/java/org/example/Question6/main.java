package org.example.Question6;

//Consider we have 2 class named Employee (empId(Integer), empName(String), empSalary(Double)) and Department (deptId(Integer), deptName(String), deptLocation(String))
//
//Create a list of Employee and Department Object
//
//	I. Perform Shorting using stream api of the Employee data in list in descending order of empSalary
//	II. Perform the Shorting using stream api of Department data in list in ascending of the employee location.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1,"Monika",20000.0));
        employees.add(new Employee(2,"Bob",3500.0));
        employees.add(new Employee(3,"David",7500.0));
        employees.add(new Employee(4,"Jack",25000.0));


        List<Employee> sortedEmployees=employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        System.out.println("Sorted Employees by employee salary: ");
        sortedEmployees.forEach(System.out::println);

        List<Department> departments=new ArrayList<>();
        departments.add(new Department(1,"HR","Texas"));
        departments.add(new Department(2,"Software Engineer","Boston"));
        departments.add(new Department(3,"Accountant","Minnesota"));
        departments.add(new Department(4,"Engineering","Melbourne"));

        List<Department> sortedDepartment=departments.stream()
                .sorted(Comparator.comparing(Department::getDeptLocation))
                .collect(Collectors.toList());

        System.out.println("Sorted Departments by deptLocation : ");
        sortedDepartment.forEach(System.out::println);
    }
}