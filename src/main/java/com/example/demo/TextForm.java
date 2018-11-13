package com.example.demo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//form機能について
public class TextForm {

    @NotNull
    @Size(min = 1, max = 127)
    private String title;
    //sizeアノテーションで文字列の制限
    //ローカル変数を宣言して以下のset関数get関数を作成

    @NotNull
    @Size(min = 1, max = 127)
    private String text;

    public void setTitle(String title) {
        this.title= title;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text= text;
    }
}