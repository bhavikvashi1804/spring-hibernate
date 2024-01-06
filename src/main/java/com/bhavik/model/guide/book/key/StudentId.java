package com.bhavik.model.guide.book.key;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class StudentId implements Serializable {

    @Column(name = "student_name")
    private String name;
    @Column(name = "student_dept")
    private Long deptId;

    public StudentId(String name){
        this.name = name;
    }
}
