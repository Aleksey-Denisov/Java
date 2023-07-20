package ru.gbhw.java.controller;

import ru.gbhw.java.module.EnteringUD;
import ru.gbhw.java.module.WriteToFile;

public class Controller {
    public Controller(){;
        new WriteToFile(new EnteringUD().consoleEnter("Введите заметку: "));
    }
}
