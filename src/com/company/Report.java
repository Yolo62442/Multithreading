package com.company;

public class Report {
    private String id;
    private String name;
    private String publish_from;
    private String publish_to;
    private int length = 0;
    private int articleNum = 0;


    public Report(String id, String name, String publish_from, String publish_to, int length) {
        this.id = id;
        this.name = name;
        this.publish_from = publish_from;
        this.publish_to = publish_to;
        this.length = length;
        articleNum++;

    }

    public int getAvrLength() {
        return length/articleNum;
    }

    public void addArticle(int length){
        this.length += length;
        articleNum++;
    }
    public void addArticle(int length, int articleNum){
        this.length += length;
        this.articleNum += articleNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublish_from() {
        return publish_from;
    }

    public void setPublish_from(String publish_from) {
        this.publish_from = publish_from;
    }

    public String getPublish_to() {
        return publish_to;
    }

    public void setPublish_to(String publish_to) {
        this.publish_to = publish_to;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    @Override
    public String toString() {
        return name + ", " + id + ", " + publish_from + ", " + publish_to + ", " + getAvrLength() + " chars\n";
    }
}
