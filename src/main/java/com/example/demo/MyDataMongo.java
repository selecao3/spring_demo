package com.example.demo;

import org.springframework.data.annotation.Id;

public class MyDataMongo {

    @Id
    private String id;
    
    private String folderId;
    private String title;
    private String text;
    

    public MyDataMongo(String title, String text) {
        super();
        this.title= title;
        this.text= text;
    }

    public String getId() {
        return id;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getFolderId(){
        return folderId;
    }
    public String getTitle(){
        return title;
    }
    public String getText(){
        return text;
    }


}