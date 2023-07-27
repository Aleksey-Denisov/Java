package ru.gbhw.java.model;

public class Ceasar {
    public String ceasar(String inString, int key, boolean encrypt){
        if(inString == null || inString.isEmpty())
            return null;
        char[] outString = new char[inString.length()];
        for(int idElement = 0; idElement < inString.length(); idElement++){
            outString[idElement] = (char)(inString.charAt(idElement) + ((encrypt) ? key : -key));
        }
        return new String(outString);
    }
}
