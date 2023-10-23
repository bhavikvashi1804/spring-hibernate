package com.bhavik.service;

import com.bhavik.model.person.Address;
import com.bhavik.model.person.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class EmployeeService {

    @Autowired
    SessionFactory sessionFactory;

    @PostConstruct
    public void doDummyInsert(){

        Address homeAddress = new Address(
                "J 203, Sainath Society",
                "Hansot Road",
                "Ankleshwar",
                "Bharuch",
                "Gujarat",
                "India",
                393001L);

        Address officeAddress = new Address(
                "B23 IT Park",
                "Station Main Road",
                "Fareli Baug",
                "Vadodara",
                "Gujarat",
                "India",
                394001L);

        Employee employee = new Employee("Bhavik", "Vashi", homeAddress, officeAddress);


        Session session = null;

        try{
            session = sessionFactory.openSession();
            session.getTransaction().begin();

            session.save(employee);

            session.getTransaction().commit();
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            if(session != null) session.getTransaction().rollback();
        }
        finally {
            if(session != null) session.close();
        }
    }
}
