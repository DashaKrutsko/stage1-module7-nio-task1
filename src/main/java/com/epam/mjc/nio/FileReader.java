package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileReader {

    public static void main(String[] args) {

        Path path = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\Profile.txt");
        File file = new File(String.valueOf(path));
       if (file.exists()) {
            getDataFromFile(file);
       }
    }

    public static Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (
                BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(": ");
                String value = keyValue[1].trim();
                switch (keyValue[0].trim()) {
                    case "Name":
                        profile.setName(value);
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(value));
                        break;
                    case "Email":
                        profile.setEmail(value);
                        break;
                    case "Phone":
                        profile.setPhone(Long.parseLong(value));
                        break;
                    default:
                        break;
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
