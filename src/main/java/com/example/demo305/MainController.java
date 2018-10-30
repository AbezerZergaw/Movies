package com.example.demo305;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {
    @Autowired
    ActorRepository actorRepository;


    @Autowired
    MovieRepository movieRepository;

    @RequestMapping
    public String index(Model model){

        Actor actor = new Actor();
        actor.setName("Sandra Bullock");
        actor.setRealName("Sandra Mae Bullowski");


        Movie movie= new Movie();
        movie.setTitle("Emoji Movie ");
        movie.setYear(2017);
        movie.setDescription("about emojies");

        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);


        actor.setMovies(movies);

        movieRepository.save(movie);
        actorRepository.save(actor);

        model.addAttribute("actors", actorRepository.findAll());
        return "index";







    }







}
