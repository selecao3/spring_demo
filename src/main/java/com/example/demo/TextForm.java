package com.example.demo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//form機能について
public class TextForm {
    

    @NotNull
    @Size(min = 10)
    private String title;

    @NotNull
    private String text;

    public TextForm() {
        super();
        //TextFormインスタンスを呼ぶとsuperによって、
        //TextFormクラスのメンバ（title,text）を書き換えることができる
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

}