package ru.gbhw.java.controller;
import ru.gbhw.java.module.Backup;

public class BackupController {
    public BackupController(){
        new Backup().backup(".","./backup");
    }
}
