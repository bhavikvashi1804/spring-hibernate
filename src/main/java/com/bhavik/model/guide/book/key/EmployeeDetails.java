package com.bhavik.model.guide.book.key;


import javax.persistence.*;

@Entity
@Table(name = "emp_tb_details")
public class EmployeeDetails {

    @Id()
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_city")
    private String city;


    @OneToOne
    @MapsId
    private Employee employee;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeDetails(){
    }
    public EmployeeDetails(String city){
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }
}
