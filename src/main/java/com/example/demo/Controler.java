package com.example.demo;


import javax.validation.Valid;

import com.example.demo.MyDataMongo;
import com.example.demo.MyDataMongoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;


/**
 * Controler
 */
@Controller
public class Controler {
    String path = "src/main/resources/static/other/hoge.txt";

    @Autowired
    MyDataMongoRepository MydataRepo;

    @Autowired
    FolderMongoRepository FolderRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        List<FolderMongo> list = FolderRepo.findAll();
        List<MyDataMongo> textlist= MydataRepo.findAll();
        mav.addObject("folderdata",list);
        mav.addObject("filedata",textlist);
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/post/folder", method = RequestMethod.POST)
    public String InputFolderData(@RequestParam("folderName") String folderName) {
        FolderMongo data = new FolderMongo(folderName);
        FolderRepo.save(data);
        return "redirect:/";
    }

    @RequestMapping(value = "/post/file", method = RequestMethod.POST)
    public String InputFileData(@RequestParam("fileName") String filename) {
        FolderMongo data = new FolderMongo(filename);
        FolderRepo.save(data);
        return "redirect:/";
    }

    @RequestMapping(value = "/page/{id}", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView mav, @PathVariable("id") String id) {
        List<MyDataMongo> list = MydataRepo.findById(id);
        mav.addObject("data", list);
        mav.setViewName("page");
        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView inputtext(ModelAndView mav) {
        mav.setViewName("edit");
        // これがないとtextFオブジェクトは使えない。
        // 具体的に言うとtextF.title, textF.textに値を代入することができない
        return mav;
    }

    @RequestMapping(value = "/post/text", method = RequestMethod.POST)
    public ModelAndView InputTextData(@RequestParam("title") String title, @RequestParam("text") String text,
            ModelAndView mav) {
        MyDataMongo data = new MyDataMongo(title, text);
        MydataRepo.save(data);
        // これがないとtextFオブジェクトは使えない。
        // 具体的に言うとtextF.title, textF.textに値を代入することができない
        return new ModelAndView("redirect:result");
    }


}