package net.nel.il.controller;


import net.nel.il.entity.Cinema;
import net.nel.il.entity.Film;
import net.nel.il.entity.Session;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/main/admin")
public class AdminController {

    @RequestMapping(value = "/addfilm", method = RequestMethod.GET)
    public ModelAndView addFilm(ModelAndView modelAndView){
        modelAndView.setViewName("addfilm");
        modelAndView.addObject("film", new Film());
        return modelAndView;
    }

    @RequestMapping(value = "/addfilm", method = RequestMethod.POST)
    public ModelAndView addFilm(ModelAndView modelAndView, @ModelAttribute Film film,
                                BindingResult result){
        modelAndView.setViewName("addfilm");
        return modelAndView;
    }

    @RequestMapping(value = "/deletefilm", method = RequestMethod.GET)
    public ModelAndView deleteFilm(ModelAndView modelAndView){
        modelAndView.setViewName("deletefilm");
        return modelAndView;
    }

    @RequestMapping(value = "/deletefilm/{filmname}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(ModelAndView modelAndView, @PathVariable String filmname){
        modelAndView.setViewName("deletefilm");
        return modelAndView;
    }

    @RequestMapping(value = "/addsession", method = RequestMethod.GET)
    public ModelAndView addSession(ModelAndView modelAndView){
        modelAndView.setViewName("addsession");
        modelAndView.addObject("session", new Session());
        return modelAndView;
    }

    @RequestMapping(value = "/addsession", method = RequestMethod.POST)
    public ModelAndView addSession(ModelAndView modelAndView, @ModelAttribute Session session,
                                BindingResult result){
        modelAndView.setViewName("addsession");
        return modelAndView;
    }

    @RequestMapping(value = "/deletesession", method = RequestMethod.GET)
    public ModelAndView deleteSession(ModelAndView modelAndView){
        modelAndView.setViewName("deletesession");
        return modelAndView;
    }

    @RequestMapping(value = "/deletesession/{sessionname}", method = RequestMethod.GET)
    public ModelAndView deleteSession(ModelAndView modelAndView, @PathVariable String sessionname){
        modelAndView.setViewName("deletesession");
        return modelAndView;
    }

    @RequestMapping(value = "/addcinema", method = RequestMethod.GET)
    public ModelAndView addCinema(ModelAndView modelAndView){
        modelAndView.setViewName("addcinema");
        modelAndView.addObject("cinema", new Cinema());
        return modelAndView;
    }

    @RequestMapping(value = "/addcinema", method = RequestMethod.POST)
    public ModelAndView addCinema(ModelAndView modelAndView, @ModelAttribute Cinema cinema,
                                   BindingResult result){
        modelAndView.setViewName("addcinema");
        return modelAndView;
    }

    @RequestMapping(value = "/deletecinema", method = RequestMethod.GET)
    public ModelAndView deleteCinema(ModelAndView modelAndView){
        modelAndView.setViewName("deletecinema");
        return modelAndView;
    }

    @RequestMapping(value = "/deletecinema/{cinemaname}", method = RequestMethod.GET)
    public ModelAndView deleteCinema(ModelAndView modelAndView, @PathVariable String cinemaname){
        modelAndView.setViewName("deletecinema");
        return modelAndView;
    }
}
