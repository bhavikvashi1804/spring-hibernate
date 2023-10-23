package com.bhavik.model.person;


import jakarta.persistence.*;

@Entity
@Table(name = "employee_tb_details")
public class Employee {

    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name",  length = 20)
    private String lastName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "line1", column = @Column(name = "home_line1")),
            @AttributeOverride( name = "line2", column = @Column(name = "home_line2")),
            @AttributeOverride( name = "city", column = @Column(name = "home_city")),
            @AttributeOverride( name = "district", column = @Column(name = "home_district")),
            @AttributeOverride( name = "state", column = @Column(name = "home_state")),
            @AttributeOverride( name = "country", column = @Column(name = "home_country")),
            @AttributeOverride( name = "pinCode", column = @Column(name = "home_pinCode")),
    })
    private Address homeAddress;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "line1", column = @Column(name = "office_line1")),
            @AttributeOverride( name = "line2", column = @Column(name = "office_line2")),
            @AttributeOverride( name = "city", column = @Column(name = "office_city")),
            @AttributeOverride( name = "district", column = @Column(name = "office_district")),
            @AttributeOverride( name = "state", column = @Column(name = "office_state")),
            @AttributeOverride( name = "country", column = @Column(name = "office_country")),
            @AttributeOverride( name = "pinCode", column = @Column(name = "office_pinCode")),
    })
    private Address officeAddress;


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

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    // constructors
    public Employee(){

    }
    public Employee(String firstName, String lastName, Address homeAddress, Address officeAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        this.officeAddress = officeAddress;
    }


    // methods
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", homeAddress=" + homeAddress +
                ", officeAddress=" + officeAddress +
                '}';
    }
}
