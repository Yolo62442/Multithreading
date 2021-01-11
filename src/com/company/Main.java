package com.company;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        File[] csvFiles = new File("C:\\Users\\Zhansaya\\Desktop\\Универ\\adv\\csv").listFiles();
        ArrayList<Articles> arr = new ArrayList<>();
        for (File f: csvFiles){
            arr.add(new Articles(f.getPath()));
        }
         for (Articles a: arr){
             a.start();
         }
        for (Articles a: arr){
            a.join();
        }

        File report = new File("C:\\Users\\Zhansaya\\Desktop\\Универ\\adv\\report\\report1.csv");
        if(report.createNewFile()) {
            PrintWriter writer = new PrintWriter(report);
            writer.write("name, id, published_from, published_to, average length \n");
            for (Report r : Articles.getAllReports()) {
                writer.write(r.toString());
            }
            writer.flush();
            writer.close();
        }
    }
}
