package com.company;

public class Article {
    private int id;
    private String source_id;
    private String source_name;
    private String title;
    private String content;
    private String published_date;

    public Article(int id, String source_id, String source_name, String title, String content, String published_date) {
        this.id = id;
        this.source_id = source_id;
        this.source_name = source_name;
        this.title = title;
        this.content = content;
        this.published_date = published_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }


}
