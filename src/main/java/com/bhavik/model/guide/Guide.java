package com.bhavik.model.guide;

import jakarta.persistence.*;

@Entity
@Table( name = "guide_details")
public class Guide {

    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "guide_name")
    private String guideName;


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
}
