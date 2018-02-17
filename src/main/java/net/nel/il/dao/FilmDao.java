package net.nel.il.dao;


import net.nel.il.entity.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmDao {

    @Autowired
    SessionFactory sessionFactory;

    public List<Film> getFilms(){
        Session session = sessionFactory.getCurrentSession();
        List<Film> films = session.createQuery("from Film").list();
        return films;
    }

    public Film getFilmByName(String filmName){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Film where title = :filmname");
        query.setParameter("filmname", filmName);
        return (Film)query.uniqueResult();
    }

}
