package ru.gbhw.java.module;
import java.util.Scanner;

public class EnteringUD {
    private Scanner in = new Scanner(System.in, "ibm866");
    public String consoleEnter(String message){
        String userData;
        while(true){
            System.out.print(message);
            try{
                userData = in.nextLine();
                if(userData.equals(""))
                    throw new RuntimeException("Введенная строка не должна быть пустой");
                else
                    break;
            }catch(RuntimeException ex){
                System.out.println(ex.getMessage());
            }
        }
        return userData;
    }
    public void scannerClose(){
        in.close();
    }
}
