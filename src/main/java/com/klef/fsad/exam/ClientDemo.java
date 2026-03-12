package com.klef.fsad.exam;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.*;

public class ClientDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // INSERT RECORDS

        Booking b1 = new Booking(1,"Ravi","2026-03-12","Confirmed");
        Booking b2 = new Booking(2,"Rahul","2026-03-13","Pending");

        session.save(b1);
        session.save(b2);

        tx.commit();

        // HQL QUERY (without WHERE)

        Query q = session.createQuery("from Booking");

        List<Booking> list = q.list();

        for(Booking b : list)
        {
            System.out.println(b.getId()+" "+b.getName()+" "+b.getDate()+" "+b.getStatus());
        }

        session.close();
        sf.close();
    }
}