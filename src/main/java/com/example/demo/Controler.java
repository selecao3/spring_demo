package com.example.demo;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controler
 */
@Controller
public class Controler {
    String path = "src/main/resources/static/other/hoge.txt";

    @RequestMapping(value = "/page", method = RequestMethod.GET)
        public ModelAndView home(ModelAndView modelAndView) throws IOException {
            FileRead filereader = new FileRead();
            String title = "title";
            String text = filereader.readAll(path);
            modelAndView.addObject("title", title);
            modelAndView.addObject("text", text);
            modelAndView.setViewName("page");
            return modelAndView;
        }

    @RequestMapping(value = "/input", method = RequestMethod.GET)
        public String inputtext(){
            return "input";
        }
    @RequestMapping(value = "/post", method = RequestMethod.POST)
        public String posttext(){
            return "input";
        }
}
