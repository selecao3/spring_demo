package com.example.demo;



import com.example.demo.MyDataMongo;
import com.example.demo.MyDataMongoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


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
    public ModelAndView InputFolder(ModelAndView mav, @RequestParam("folderName") String folderName) {
        if (FolderRepo.existsByFolderName(folderName)) {
            message = "ダブっている";
        }else if (folderName == "") {
            message = "文字が入力されていない";
        }else{
            FolderMongo data = new FolderMongo(folderName);
            FolderRepo.save(data);
        }
        mav.setViewName("redirect:/");
        return mav;
    }

    @RequestMapping(value = "/edit/newFile", method = RequestMethod.GET)
    public ModelAndView EditNewFile(
        ModelAndView mav
    ) {
        List<FolderMongo> folderlist = FolderRepo.findAll();
        mav.addObject("folderdata", folderlist);
        mav.addObject("targetID","file");
        mav.setViewName("edit");
        return mav;
    }

    @RequestMapping(value = "/post/file", method = RequestMethod.POST)
    public ModelAndView InputFile(@RequestParam("folderName") String folderName,
            @RequestParam("title") String title, @RequestParam("text") String text, ModelAndView mav) {
        MyDataMongo data = new MyDataMongo(folderName, title, text);
        MydataRepo.save(data);
        return new ModelAndView("redirect:/");
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView EditFile(
        @PathVariable("id") String id,
        ModelAndView mav
    ) {
        List<FolderMongo> folderlist = FolderRepo.findAll();
        MyDataMongo filedata = MydataRepo.findById(id);
        mav.addObject("folderdata", folderlist);
        mav.addObject("filedata", filedata);
        mav.addObject("targetID",id);
        mav.setViewName("edit");
        return mav;
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.POST)
    public ModelAndView UpdateFile(
        @PathVariable("id") String id,
        @RequestParam("folderName") String folderName,
        @RequestParam("title") String title,
        @RequestParam("text") String text, ModelAndView mav) {
        MyDataMongo data;
        if (MydataRepo.existsById(id)) {
            data = MydataRepo.findById(id);
            data.setAll(folderName, title, text);
            // data.setFolderName(folderName);
            // data.setTitle(title);
            // data.setText(text);
        }else{
            data = new MyDataMongo(folderName, title, text);
        }
        MydataRepo.save(data);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/page/{id}", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView mav, @PathVariable("id") String id) {

        MyDataMongo data = MydataRepo.findById(id);
        List<FolderMongo> folderlist = FolderRepo.findAll();
        mav.addObject("data", data);
        mav.addObject("folderdata", folderlist);
        mav.setViewName("page");
        return mav;
    }



}