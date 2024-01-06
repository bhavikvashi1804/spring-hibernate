package com.bhavik.model.guide.book.key;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dept_tb_dept")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dept_name")
    private String name;

    public Department(String name){
        this.name = name;
    }
}
