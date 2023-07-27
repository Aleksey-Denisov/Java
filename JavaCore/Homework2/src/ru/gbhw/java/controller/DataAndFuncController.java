package ru.gbhw.java.controller;

import ru.gbhw.java.model.Ceasar;
import ru.gbhw.java.model.Shift;
import ru.gbhw.java.model.Sort;

public class DataAndFuncController {
    public DataAndFuncController(){
        sort(new int[]{3,8,-2,3,4,1,-5,4});
        ceasarEncrypt(ceasarEncrypt("test", true),false);
        shift(new int[]{1,2,3,4,5,6,7,8}, 3);
    }
    private void sort(int[] array){
        int minValue = array[0];
        int maxValue = array[0];
        for(int i : array){
            if(minValue > i)
                minValue = i;
            if(maxValue < i)
                maxValue = i;
        }
        for(int i : new Sort().countingSort(array, minValue, maxValue)){
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
    private String ceasarEncrypt(String inString, boolean encrypt){
        String ouString = new Ceasar().ceasar(inString, 3, encrypt);
        System.out.println(ouString);
        return ouString;

    }
    private void shift(int[] array, int key){
        for(int i : new Shift().shift(array, key)){
            System.out.print(i + " ");
        } 
    }
}
