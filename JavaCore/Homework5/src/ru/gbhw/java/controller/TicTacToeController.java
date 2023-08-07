package ru.gbhw.java.controller;

import ru.gbhw.java.module.TicTacToe;

public class TicTacToeController {
    private final int SIZE = 9;
    private final String FILEPATH = "./tictactoe";
    private TicTacToe ticTacToe;

    public TicTacToeController(){
        ticTacToe = new TicTacToe();
        System.out.println("Загружаем сохраненное поле");
        ticTacToe.loadgame(SIZE, FILEPATH);
        System.out.println("Создадим новую игру и сохраним в файл");
        ticTacToe.newGame(SIZE, FILEPATH);
    }
}
