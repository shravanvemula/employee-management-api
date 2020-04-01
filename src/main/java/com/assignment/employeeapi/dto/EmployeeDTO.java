package com.assignment.employeeapi.dto;



public class EmployeeDTO {



    private int id;


    private String firstName;


    private String lastName;


    private String email;


    // define constructors

    public EmployeeDTO() {

    }

    public EmployeeDTO(int id,String firstName, String lastName, String email) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // define tostring

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }

}
