package net.nel.il.service;


import net.nel.il.dao.SessionDAO;
import net.nel.il.entity.Cinema;
import net.nel.il.entity.Session;
import net.nel.il.entity.SessionList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionService {

    @Autowired
    SessionDAO sessionDAO;

    @Transactional
    public List<?>[] getSessionsByFilmName(String filmName){

        return null;
    }
}
