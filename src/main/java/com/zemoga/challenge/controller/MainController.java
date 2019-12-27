package com.zemoga.challenge.controller;

import java.util.ArrayList;
import java.util.List;
import com.zemoga.challenge.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private PortfolioRepository portfolioRepository;

    private static final List FILL = new ArrayList(){
        {
            add("");
            add("");
            add("");
            add("");
            add("");
        }
    };

    @GetMapping("/")
    public String welcome(Model model){
        List tweets = new ArrayList();
        tweets.add("Primer cometario");
        tweets.add("segundo cometario");
        tweets.add("tercer cometario");
        tweets.add("cuarto cometario");
        tweets.add("quito cometario");
        if(tweets.size()<5){
           tweets.addAll(FILL);
        }
        //Iterable<Portfolio> all = portfolioRepository.findAll();
        model.addAttribute("tweet1",tweets.get(0));
        model.addAttribute("tweet2",tweets.get(1));
        model.addAttribute("tweet3",tweets.get(2));
        model.addAttribute("tweet4",tweets.get(3));
        model.addAttribute("tweet5",tweets.get(4));
        model.addAttribute("name","andres");
        model.addAttribute("text","aqui dejamos mucho texto para que el programa lo ponga en el frame nuevo y lo pegamos varias veces, aqui dejamos mucho texto para que el programa lo ponga en el frame nuevo y lo pegamos varias veces, aqui dejamos mucho texto para que el programa lo ponga en el frame nuevo y lo pegamos varias veces, aqui dejamos mucho texto para que el programa lo ponga en el frame nuevo y lo pegamos varias veces, aqui dejamos mucho texto para que el programa lo ponga en el frame nuevo y lo pegamos varias veces, aqui dejamos mucho texto para que el programa lo ponga en el frame nuevo y lo pegamos varias veces");
        return "index";
    }
}
