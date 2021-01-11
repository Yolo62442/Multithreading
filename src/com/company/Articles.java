package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Articles extends Thread{
    private ArrayList<Article> articles;
    private int artclNum = 0;
    private String path;
    private ArrayList<Report> reports;
    private static ArrayList<Report> allReports = new ArrayList<>();

    public Articles(String path) {
        this.path = path;
        articles = new ArrayList<>();
        reports = new ArrayList<>();
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public void run(){
        File csv = new File(path);
        try(BufferedReader bufread = Files.newBufferedReader(csv.toPath(), StandardCharsets.UTF_8)){
            bufread.readLine();
            String line = bufread.readLine();
            String[] data;
            int id = 0;
            Article article;
            while (line != null){
                data = line.split(",");
                if(data.length == 6) {
                    article = new Article(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5]);
                    articles.add(article);
                    artclNum++;
                    createReport(article);
                }
                line = bufread.readLine();
            }
            createAllReport();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(currentThread());
        }
    }
    private void createReport(Article a ){
        boolean exist = false;

        for (Report r: reports){
            if(r.getId().compareToIgnoreCase(a.getSource_id()) == 0){
                exist = true;
                if(r.getPublish_from().compareTo(a.getPublished_date()) > 0){
                    r.setPublish_from(a.getPublished_date());
                }else if (r.getPublish_to().compareTo(a.getPublished_date()) < 0){
                    r.setPublish_to(a.getPublished_date());
                }
                r.addArticle(a.getContent().length());
                break;
            }
        }
        if(exist) return;
        reports.add(new Report(a.getSource_id(), a.getSource_name(), a.getPublished_date(), a.getPublished_date(), a.getContent().length()));
    }

    private synchronized void createAllReport(){
        boolean exist;
        for (Report r: reports){
            exist = false;
            for (Report all: allReports) {
                if (r.getId().compareToIgnoreCase(all.getId()) == 0) {
                    exist = true;
                    if (all.getPublish_from().compareTo(r.getPublish_from()) > 0) {
                        all.setPublish_from(r.getPublish_from());
                    } else if (all.getPublish_to().compareTo(r.getPublish_to()) < 0) {
                        all.setPublish_to(r.getPublish_to());
                    }
                    all.addArticle(r.getLength(), r.getArticleNum());
                    break;
                }
            }
            if(exist) continue;
            allReports.add(r);
        }

    }

    public static ArrayList<Report> getAllReports() {
        return allReports;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public int getArtclNum() {
        return artclNum;
    }

    public void setArtclNum(int artclNum) {
        this.artclNum = artclNum;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
