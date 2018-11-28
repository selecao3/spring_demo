package com.example.demo;

import org.springframework.data.annotation.Id;

public class MyDataMongo {

    @Id
    private String id;
    
    private String folderName;
    private String title;
    private String text;
    
    public MyDataMongo() {
    }

    public MyDataMongo(String folderName,String title, String text) {
        super();
        this.folderName = folderName;
        this.title= title;
        this.text= text;
    }


    public String getId() {
        return id;
    }


	public void setFolderName(String folderName) {
        this.folderName = folderName;
	}
    public String getFolderName(){
        return folderName;
    }
	public void setTitle(String title) {
        this.title = title;
	}
    public String getTitle(){
        return title;
    }
	public void setText(String text) {
        this.text = text;
	}
    public String getText(){
        return text;
    }




}