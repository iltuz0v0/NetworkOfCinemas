package net.nel.il.service;

import net.nel.il.dao.FilmDao;
import net.nel.il.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmDao filmDao;

    @Transactional
    public List<Film> getFilms(){
        List<Film> films = filmDao.getFilms();
        return films;
    }

    @Transactional
    public Film getFilmByName(String filmName){
        return filmDao.getFilmByName(filmName);
    }
}
