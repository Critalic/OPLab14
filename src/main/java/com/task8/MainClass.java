package com.task8;

import java.io.*;
import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        try {
            cypher("receive.txt","file.txt",  (byte) 2);
        } catch (IOException e) {
            System.out.println("IO not working");
        }
    }

    public static void cypher(String path, String destination, byte key) throws IOException {
        try (FileInputStream fileInput = new FileInputStream(path);
             FileOutputStream fileOutput = new FileOutputStream(destination))
        {
            byte[] buffer = new byte[512];

            while(fileInput.read(buffer)>0) {
                for(byte b : buffer)
                fileOutput.write((char) b^key);
            }

        }
    }
}
