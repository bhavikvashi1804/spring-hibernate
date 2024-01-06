package com.bhavik.model.guide.book.key;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @EmbeddedId
    private StudentId studentId;

    @Column(name = "student_percent")
    private Long percentage;

    @ManyToOne
    @MapsId("deptId")
    @JoinColumn(name = "student_dept")
    Department department;

    public Student(StudentId studentId, Long percentage){
        this.studentId = studentId;
        this.percentage = percentage;
    }
}
