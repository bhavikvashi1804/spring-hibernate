package com.bhavik.model.guide.message;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "message_tb_details")
public class Message {

    // properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;
    @Column(name = "message_text", nullable = false)
    @Basic(fetch = FetchType.LAZY)
    //@JsonIgnore
    private String msgText;


    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMsgText() {
        return msgText;
    }
    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    // constructor
    public Message(){
    }
    public Message(String msgText){
        this.msgText = msgText;
    }

    // methods
    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", msgText='" + msgText + '\'' +
                '}';
    }
}
