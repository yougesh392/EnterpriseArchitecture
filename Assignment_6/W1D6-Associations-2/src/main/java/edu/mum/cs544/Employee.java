package edu.mum.cs544;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long employeeNumber;
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Department department;

    @ManyToOne
    private Office office;

    public Employee() {
    }

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Employee(String name, Department department, Office office) {
        this.name = name;
        this.department = department;
        this.office = office;
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", office=" + office +
                '}';
    }
}
