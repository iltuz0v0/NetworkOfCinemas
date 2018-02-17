package net.nel.il.dao;

import net.nel.il.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.System;
import java.util.List;

@Repository
public class SessionDAO {

    @Autowired
    SessionFactory sessionFactory;

    public List<SessionList> getSessionEntriesByFilmName(String filmName){
        org.hibernate.Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from SessionList where session.product.film.title = :filmname");
            query.setParameter("filmname", filmName);
        return (List<SessionList>) query.list();
    }
    /*public List<Cinema> getCinemasByCity(String city){

    }*/
}
