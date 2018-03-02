package net.nel.il.controller;

import net.nel.il.entity.*;
import net.nel.il.service.FilmService;
import net.nel.il.service.SessionService;
import net.nel.il.session_entries.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/main")
@SessionAttributes({"client", "loggeduser"})
public class FilmController {

    @Autowired
    FilmService filmService;

    @Autowired
    SessionService sessionService;

    @RequestMapping(value = "/{filmname}", method = RequestMethod.GET)
    public ModelAndView showFilm(ModelAndView modelAndView, @PathVariable String filmname,
                                 @SessionAttribute("client") Client client){
        if(!isCity(client)) return new ModelAndView("redirect:/main/choice");
        modelAndView.setViewName("film");
        Film film = filmService.getFilmByName(filmname);
        modelAndView.addObject("film", film);
        modelAndView.addObject("genres", film.getGenres());
        return modelAndView;
    }

    @RequestMapping(value = "/{filmname}/table", method = RequestMethod.GET)
    public ModelAndView showTable(ModelAndView modelAndView, @PathVariable String filmname,
                                  @SessionAttribute("client") Client client){
        if(!isCity(client)) return new ModelAndView("redirect:/main/choice");
        modelAndView.setViewName("table");
        List<?>[] arrays =
                sessionService.getSessionsByCityAndByFilmName(client.getCity(), filmname);
        modelAndView.addObject("cinemas", (ArrayList<Cinema>)arrays[0]);
        modelAndView.addObject("sessions", (ArrayList<ArrayList<SessionList>>)arrays[1]);
        return modelAndView;
    }
    public boolean isCity(Client client){
        return !client.getCity().equals(" ");
    }

}
