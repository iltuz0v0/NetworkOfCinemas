package net.nel.il.controller;

import net.nel.il.entity.Film;
import net.nel.il.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("city")
public class MainController {
    private final int filmsAmount = 3;
    @Autowired
    private FilmService filmService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView mainPageRedirect(ModelAndView modelAndView){
        modelAndView.setViewName("redirect:/main");
        return modelAndView;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView showMainPage(ModelAndView modelAndView){
        modelAndView.setViewName("main");
        modelAndView.addObject("city", null);
        List<Film> films = filmService.getFilms();
        List<Film> premiereFilms = new ArrayList<Film>();
        for (int filmsAmount = 0; filmsAmount < films.size(); filmsAmount++){
            premiereFilms.add(films.get(filmsAmount));
            if(filmsAmount == this.filmsAmount - 1) break;
        }
        modelAndView.addObject("premierefilms", premiereFilms);
        if(films.size() > this.filmsAmount){
            modelAndView.addObject("films", films.subList(filmsAmount, films.size()));
        }
        return modelAndView;
    }

    @RequestMapping(value = "/main/choice", method = RequestMethod.GET)
    public ModelAndView getCity(ModelAndView modelAndView){
        modelAndView.setViewName("choice");
        return modelAndView;
    }
    @RequestMapping(value = "/main/choice", method = RequestMethod.POST)
    public ModelAndView getCity(ModelAndView modelAndView, @RequestParam String choice,
                                @SessionAttribute("city") String city){
        System.out.println(choice);
        modelAndView.setViewName("choice");
        return modelAndView;
    }

    @RequestMapping(value = "/main/getimage/{poster}", method = RequestMethod.GET)
    public @ResponseBody
    void getDownloadBook(@PathVariable String poster,
                         HttpServletResponse response) throws IOException {
        File file = new File("/home/ilya/Images/1.jpg");
        InputStream fileInputStream = new FileInputStream(file);
        response.setContentType("image/*");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + poster);
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(fileInputStream, response.getOutputStream());
    }
}