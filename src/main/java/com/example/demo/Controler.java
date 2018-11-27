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
    String message;

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
        mav.addObject("message", message);
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/post/folder", method = RequestMethod.POST)
    public ModelAndView InputFolderData(ModelAndView mav, @RequestParam("folderName") String folderName) {
        if (FolderRepo.existsByFolderName(folderName)) {
            message = "ダブっている";
        }else if (folderName == "") {
            message = "文字が入力されていない";
        }else{
            FolderMongo data = new FolderMongo(folderName);
            FolderRepo.save(data);
            message = "ダブっていない";
        }
        mav.setViewName("redirect:/");
        return mav;
    }

    @RequestMapping(value = "/post/file", method = RequestMethod.POST)
    public ModelAndView InputTextData(@RequestParam("folderName") String folderName,
            @RequestParam("title") String title, @RequestParam("text") String text, ModelAndView mav) {

        MyDataMongo data = new MyDataMongo(folderName, title, text);
        MydataRepo.save(data);
        // これがないとtextFオブジェクトは使えない。
        // 具体的に言うとtextF.title, textF.textに値を代入することができない
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/post/{id}/edit", method = RequestMethod.POST)
    public ModelAndView UpdateTextData(
        @RequestParam("folderName") String folderName,
        @RequestParam("title") String title,
        @RequestParam("text") String text,
        ModelAndView mav) {

        MyDataMongo data = new MyDataMongo(folderName, title, text);
        MydataRepo.save(data);

        // これがないとtextFオブジェクトは使えない。
        // 具体的に言うとtextF.title, textF.textに値を代入することができない
        return new ModelAndView("redirect:/");
    }


    @RequestMapping(value = "/page/{id}", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView mav, @PathVariable("id") String id) {
        List<MyDataMongo> list = MydataRepo.findById(id);
        List<FolderMongo> folderlist = FolderRepo.findAll();
        mav.addObject("filedata", list);
        mav.addObject("folderdata", folderlist);
        mav.setViewName("page");
        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView inputtext(ModelAndView mav) {
        List<FolderMongo> folderlist = FolderRepo.findAll();
        mav.addObject("folderdata", folderlist);
        mav.setViewName("edit");
        return mav;
    }



}