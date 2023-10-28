package com.bhavik.model.student;

import com.bhavik.model.guide.Guide;
import jakarta.persistence.*;

@Entity
@Table( name = "student_tb_details")
public class Student {

    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "guide_id")
    Guide guide;


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
    public Guide getGuide() {
        return guide;
    }
    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    // constructor
    public Student(){

    }
    public Student(String firstName, String lastName, Guide guide){
        this.firstName = firstName;
        this.lastName = lastName;
        this.guide = guide;
    }


    // methods
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", guide='" + guide + '\'' +
                '}';
    }
}
