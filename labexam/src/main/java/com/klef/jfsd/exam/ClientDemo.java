package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
    
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        
        Car car = new Car();
        car.setName("MARUTI");
        car.setType("suv");
        car.setMax_Speed(100);
        car.setColour("BLACK");
        car.setNooffDoors(4);

        Truck truck = new Truck();
        truck.setName("Volvo");
        truck.setType("Diesel");
        truck.setMaxSpeed(100);
        truck.setColour("yellow");
        truck.setLoadCapacity(300);

      
        session.save(car);
        session.save(truck);

        
        session.getTransaction().commit();

        System.out.println("SAVED SUCCESFULLY");

        session.close();
        sessionFactory.close();
    }
}
