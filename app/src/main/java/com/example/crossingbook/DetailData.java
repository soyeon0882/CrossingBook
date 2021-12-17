package com.example.crossingbook;

public class DetailData {


    String title;
    String description;
    String authors;
    String publisher;
    String publishedDate;
    String imageLinks;

    public DetailData() {
    }

    public String getBookTitle() {
        return title;
    }

    public void setBookTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(String imageLinks) {
        this.imageLinks = imageLinks;
    }

    public DetailData(String title, String description, String authors, String publisher, String imageLinks) {
        this.title = title;
        this.description = description;
        this.authors = authors;
        this.publisher = publisher;
         this.imageLinks = imageLinks;

    }
}