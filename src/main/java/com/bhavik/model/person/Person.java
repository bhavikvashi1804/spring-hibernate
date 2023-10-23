package com.bhavik.model.person;


import jakarta.persistence.*;

@Entity
@Table(name = "person_tb_details")
public class Person {

    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name",  length = 20)
    private String lastName;

    @Embedded
    private Address homeAddress;


    //getters & setters
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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    // constructors
    public Person(){

    }
    public Person(String firstName, String lastName, Address homeAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
    }


    // methods

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", homeAddress=" + homeAddress +
                '}';
    }
}
