package com.itenas.projek_uas.pojo;

public class Employee {
    private String id_employee;
    private String nama;
    private Employee employee;
    private boolean loginStatus;
    
    public Employee() {
    }

    public Employee(String id_employee, String nama, Employee employee, boolean loginStatus) {
        this.id_employee = id_employee;
        this.nama = nama;
        this.employee = employee;
        this.loginStatus = loginStatus;
    }

    public String getId_employee() {
        return id_employee;
    }

    public void setId_employee(String id_employee) {
        this.id_employee = id_employee;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
}
