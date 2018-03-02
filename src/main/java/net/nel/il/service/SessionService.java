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
    public ArrayList<?>[] getSessionsByCityAndByFilmName(String city, String filmName){
        ArrayList<Cinema> cinemas = (ArrayList<Cinema>) sessionDAO.getCinemasByCity(city);
        ArrayList<ArrayList<SessionList>> sessions = new ArrayList<ArrayList<SessionList>>();
        for(int amount = 0; amount < cinemas.size(); amount++){
            sessions.add((ArrayList<SessionList>) sessionDAO.getSessionsByCityAndFilmNameAndCinema(city,
                    filmName, cinemas.get(amount).getName()));
        }
        return new ArrayList<?>[]{cinemas, sessions};
    }

    @Transactional
    public void saveSession(Session session){
        sessionDAO.saveSession(session);
    }
}
