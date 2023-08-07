package ru.gbhw.java.module;

import java.util.Random;

public class TicTacToe {
    private int[] field;

    public void loadgame(int size, String filepath){
        field = new ActionFile().readFile(size, filepath);
        if(field == null)
            System.out.println("Сохраненного игрового поля не существует");
        else{
            printField();
        }
    }
    public void newGame(int size, String filepath){
        field = randomField(size);
        printField();
        new ActionFile().writeToFile(field, filepath);
    }
    private void printField(){
        StringBuilder sb = new StringBuilder();
        State state = new State();
        for(int idElement = 0; idElement < field.length; idElement++){
            if(idElement == 2 || idElement == 5)
                sb.append(state.getState(field[idElement]) + System.lineSeparator() + "-|-|-" + System.lineSeparator());
            else if (idElement == 8)
                sb.append(state.getState(field[idElement]));
            else
                sb.append(state.getState(field[idElement]) + "|");
        }
        System.out.println(sb.toString());
    }
    private int[] randomField(int size){
        int[] fieldOfStates = new int[size];
        Random random = new Random();
        for (int idElement = 0; idElement < size; idElement++) {
            fieldOfStates[idElement] = random.nextInt(4);
        }
        return fieldOfStates;
    }
}
