package net.nel.il.controller;

import net.nel.il.entity.Film;
import net.nel.il.entity.Genre;
import net.nel.il.entity.Session;
import net.nel.il.service.FilmService;
import net.nel.il.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/main")
@SessionAttributes("city")
public class FilmController {

    @Autowired
    FilmService filmService;

    @Autowired
    SessionService sessionService;

    @RequestMapping(value = "/{filmname}", method = RequestMethod.GET)
    public ModelAndView showFilm(ModelAndView modelAndView, @PathVariable String filmname,
                                 @SessionAttribute("city") String city){
        if(!isCity(city)) return new ModelAndView("redirect:/main/choice");
        modelAndView.setViewName("film");
        Film film = filmService.getFilmByName(filmname);
        modelAndView.addObject("film", film);
        modelAndView.addObject("genres", film.getGenres());
        return modelAndView;
    }

    @RequestMapping(value = "/{filmname}/table", method = RequestMethod.GET)
    public ModelAndView showTable(ModelAndView modelAndView, @PathVariable String filmname,
                                  @SessionAttribute("city") String city){
        if(!isCity(city)) return new ModelAndView("redirect:/main/choice");
        modelAndView.setViewName("table");
        //List<Session> sessions = sessionService.getSessionsByFilmName(filmname);
        return modelAndView;
    }
    public boolean isCity(String destinationCity){
        System.out.println(destinationCity);
        return destinationCity!=null;
    }

}
