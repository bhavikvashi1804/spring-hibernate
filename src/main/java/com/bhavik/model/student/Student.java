package com.bhavik.model.student;

public class Student {

    //properties
    private Long id;
    private String firstName;
    private String lastName;


    //getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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


    // constructor
    public Student(){

    }
    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }


    // methods
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
