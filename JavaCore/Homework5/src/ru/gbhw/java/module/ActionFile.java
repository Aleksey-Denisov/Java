package ru.gbhw.java.module;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ActionFile {
    public void writeToFile(int[] field, String path){
        try{
            File file = new File(path);
            StringBuilder sb = new StringBuilder();
            if(!file.exists()){
                file.createNewFile();
            }
            for(int element : field){
                sb.append(element);
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
            bw.write(sb.toString());
            bw.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public int[] readFile(int size, String path){
        int[] field = new int[size];
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            int element;
            int idElement = 0;
            while((element = br.read()) != -1){
                field[idElement] = Character.getNumericValue(element);
                idElement++;
            }
            return field;
        }catch(IOException ex){
            System.out.println("Файла не существует");
            return null;
        }
    }
}
