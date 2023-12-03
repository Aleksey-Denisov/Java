package main.java.ru.gbhw.Task1;

public class Dog extends Animal {

    private int swims;

    public Dog(String name, int age) {
        super(name, age);
    }

    public int getSwims() {
        return swims;
    }

    public void setSwims(int swims) {
        this.swims = swims;
    }

    public String makeSound() {
        return "Гав";
    }
    
    public String giveAPaw() {
        return "Дал лапу";
    }
    public void test(int length, boolean result, String command){

    }
}
