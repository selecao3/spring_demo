package com.nitech.supportdatas;

import org.springframework.data.annotation.Id;

public class FolderMongo {
    @Id
    private String id;
    
    private String folderName;
    

    public FolderMongo(String folderName) {
        super();
        this.folderName= folderName;
    }

    public String getId() {
        return id;
    }
    public String getFolderName() {
        return folderName;
    }



}