package com.bhavik.model.guide;

import com.bhavik.model.student.Student;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "guide_details")
public class Guide {

    //properties
    @Id
    @Column(name = "guide_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "guide_name")
    private String guideName;

    @OneToMany(mappedBy = "guide")
    Set<Student> studentsList = new HashSet<>();


    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getGuideName() {
        return guideName;
    }
    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }
    public Set<Student> getStudentsList() {
        return studentsList;
    }
    public void setStudentsList(Set<Student> studentsList) {
        this.studentsList = studentsList;
    }

    // constructor
    public Guide(){
    }
    public Guide(String guideName){
        this.guideName = guideName;
    }

    // methods
    @Override
    public String toString() {
        return "Guide{" +
                "id=" + id +
                ", guideName='" + guideName + '\'' +
                '}';
    }

    //helper methods
    public void addStudent(Student student){
        studentsList.add(student);
        student.setGuide(this);
    }

    public void removeStudent(Student student){
        studentsList.remove(student);
        student.setGuide(null);
    }
}
