package com.example.crossingbook;

import java.util.ArrayList;

public class Book {


        private int id;
        private String title;
        private String description;
        private String thumbnail;
        private String publisher;



    public Book(String title, String description,String thumbnail, String publisher)
    { this.title = title; this.description= description; this.thumbnail = thumbnail; this.publisher = publisher;}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getThumbnail(){return thumbnail;}
    public String getPublisher(){return publisher;}


    public void setTitle(String title) {
        this.title = title;
    }






}


//   public Book(String bookTitle,String description,String  authors,  String  publisher, String  publishedDate, String  imageLinks){
//            this.bookTitle = bookTitle;
//            this.description =description;
//            this.authors = authors;
//            this.publisher = publisher;
//            this.publishedDate = publishedDate;
//




