package ru.gbhw.java.model;

public class Shift {
    public int[] shift(int[] inArray, int key){
        if(key <= 0 || key > inArray.length)
            return inArray;
        int[] outArray = new int[inArray.length];
        int idOutArray = 0;
        for(int idElement = inArray.length - key; idElement < inArray.length; idElement++){
            outArray[idOutArray] = inArray[idElement];
            idOutArray++;
        }
        for(int idElement = 0; idElement < inArray.length - key; idElement++){
            outArray[idOutArray] = inArray[idElement];
            idOutArray++;
        }
        return outArray;
    }
}
