package com.example.demo;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controler
 */
@Controller
public class Controler {
    String path = "src/main/resources/static/other/hoge.txt";

    @ModelAttribute
    TextForm setupform(){
        return new TextForm();
    }
    @RequestMapping(value = "/page", method = RequestMethod.GET)
        public ModelAndView home(ModelAndView modelAndView) throws IOException {
            //modelAndView冗長。改善できそう
            FileRead filereader = new FileRead();
            String title = "title";
            String text = filereader.readAll(path);
            modelAndView.addObject("title", title);
            modelAndView.addObject("text", text);
            modelAndView.setViewName("page");
            return modelAndView;
        }

    @RequestMapping(value = "/input", method = RequestMethod.GET)
        public ModelAndView inputtext(ModelAndView mav){
            mav.setViewName("input");
            mav.addObject("textF",new TextForm());
            return mav;
        }
    @RequestMapping(value = "/result", method = RequestMethod.GET)
        public String result(){
            return "result";
        }
    @RequestMapping(value = "/post", method = RequestMethod.POST)
        public ModelAndView result(ModelAndView mav){
            mav.setViewName("result");
            mav.addObject("textF",new TextForm());
            return mav;
        }
    

}
