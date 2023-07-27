package ru.gbhw.java.model;

public class Sort {
    public int[] countingSort(int[] inArray, int minValue, int maxValue){
        int idInArray = 0;
        int idArray = 0;
        int idOutArray = 0;
        int lengthArray = maxValue + (minValue >= 0 ? minValue : minValue * -1) + 1;
        int[] outArray = new int[inArray.length];
        int[] middleArray = new int[lengthArray];
        for(int idElement = 0; idElement < lengthArray; idElement++){
            middleArray[idElement] = 0;
        }
        for(int idElement = minValue; idElement <= maxValue; idElement++){
            for (int id = 0; id < inArray.length; id++){
                if(inArray[id] == idElement){
                    middleArray[idInArray] += 1;
                }
            }
            idInArray++;
        }
        for(int idElement = minValue; idElement <= maxValue; idElement++){
            while(middleArray[idOutArray] > 0){
                outArray[idArray] = idElement;
                idArray++;
                middleArray[idOutArray]--;
            }
            idOutArray++;
        }
        return outArray;
    }
}
