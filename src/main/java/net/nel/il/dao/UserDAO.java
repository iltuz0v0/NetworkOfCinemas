package net.nel.il.dao;

import net.nel.il.entity.users.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    @Autowired
    SessionFactory sessionFactory;

    public User findByUsername(String username){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username = :currentUsername");
        query.setParameter("currentUsername", username);
        return (User)query.uniqueResult();
    }
}
