package ru.gbhw.java.module;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Backup {
    public void backup(String source, String destination){
        try{
            if(!Files.exists(Paths.get(source)))
                throw new IOException("Данный каталог не найден");
            File[] files = new File(source).listFiles();
            if (!Files.exists(Paths.get(destination)))
                Files.createDirectory(Paths.get(destination));
            if (Files.isRegularFile(Paths.get(source)))
                Files.copy(Paths.get(source), Paths.get(destination + "/" + Paths.get(source).getFileName()), REPLACE_EXISTING);
            if(files == null)
                return;
            for(File file : files){
                if (file.isFile())
                    Files.copy(Paths.get(file.getPath()), Paths.get(destination + "/" + Paths.get(file.getPath()).getFileName()), REPLACE_EXISTING);
                else
                    backup(file.getPath(), destination + "/" + file.getName());
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
