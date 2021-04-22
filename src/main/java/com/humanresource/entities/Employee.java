package com.humanresource.entities;

public class Employee {

    private int employeeCode;

    private String empName;

    private String location;

    private String email;

    private String dOB;

    public Employee(int employeeCode, String empName, String location, String email, String dOB) {
        super();
        this.employeeCode = employeeCode;
        this.empName = empName;
        this.location = location;
        this.email = email;
        this.dOB = dOB;
    }

    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    @Override
    public String toString() {
        return "Employee [employeeCode=" + employeeCode + ", empName=" + empName + ", location=" + location + ", email="
                + email + ", dOB=" + dOB + "]";
    }

}
