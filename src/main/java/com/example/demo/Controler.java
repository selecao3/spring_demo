package com.example.demo;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controler
 */
@Controller
public class Controler {
    String path = "src/main/resources/static/other/hoge.txt";

    @RequestMapping(value = "/", method = RequestMethod.GET)
        public String index(){
            return "index";
        }
    // @RequestMapping(value = "/page", method = RequestMethod.GET)
    //     public ModelAndView home(ModelAndView modelAndView) throws IOException {
    //         //modelAndView冗長。改善できそう
    //         FileRead filereader = new FileRead();
    //         String title = "title";
    //         String text = filereader.readAll(path);
    //         modelAndView.addObject("title", title);
    //         modelAndView.addObject("text", text);
    //         modelAndView.setViewName("page");
    //         return modelAndView;
    //     }
    @RequestMapping(value = "/page", method = RequestMethod.GET)
        public ModelAndView home(ModelAndView modelAndView,
            @Valid TextForm textF
        ){
            //modelAndView冗長。改善できそう
            textF.setText("hage");
            textF.setTitle("hoge");
            String unko = textF.getText();
            textF.getTitle();
            System.out.println("unkoなう");
            System.out.println(unko);
            
            modelAndView.addObject("textF", textF);
            modelAndView.setViewName("page");
            return modelAndView;
        }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
        public ModelAndView inputtext(ModelAndView mav){
            mav.setViewName("edit");
            mav.addObject("textF",new TextForm());
            //これがないとtextFオブジェクトは使えない。
            //具体的に言うとtextF.title, textF.textに値を代入することができない
            return mav;
        }
    @RequestMapping(value = "/result", method = RequestMethod.GET)
        public String result(Model model){
            return "result";
        }
    @RequestMapping(value = "/post", method = RequestMethod.POST)
        public String results(
            RedirectAttributes ra,
            @Valid TextForm textF,
            BindingResult result
         ){
            if (!result.hasErrors()) {
                //エラーが無い時
                ra.addFlashAttribute("noErrors", true);
        }
        ra.addFlashAttribute("textF", textF);
        return "redirect:/page";
    }

}
