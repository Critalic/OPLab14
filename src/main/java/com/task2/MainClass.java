package com.task2;

import java.io.*;
import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        try {
            System.out.println(lastShortestString("file.txt"));

        } catch (IOException ex) {
            System.out.println("IO not working");
        }
    }

    public static String lastShortestString (String path) throws IOException {
        String str;
        try (FileInputStream fis = new FileInputStream(path);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr))
        {

            ArrayList<String> strings = new ArrayList<>();
            while ((str = br.readLine()) != null) {
                strings.add(str);
            }
            if(strings.size() ==0) str="No strings were found in the given file";
            else {
                str = strings.get(0);
                for (String i : strings) {
                    if (i.length() <= str.length()) str = i;
                }


            }

        }
        return str;
    }
}
