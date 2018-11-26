package com.example.demo;

import org.springframework.data.annotation.Id;

public class MyDataMongo {

    @Id
    private String id;
    
    private String filename;
    private String title;
    private String text;
    

    public MyDataMongo(String filename,String title, String text) {
        super();
        this.filename = filename;
        this.title= title;
        this.text= text;
    }

    public String getId() {
        return id;
    }


    public String getFileName(){
        return filename;
    }
    public String getTitle(){
        return title;
    }
    public String getText(){
        return text;
    }


}