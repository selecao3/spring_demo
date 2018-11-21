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

    @RequestMapping(value = "/page", method = RequestMethod.GET)
        public String home(){
            return "page";
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
