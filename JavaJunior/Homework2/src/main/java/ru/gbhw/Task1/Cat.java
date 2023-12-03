package main.java.ru.gbhw.Task1;

public class Cat extends Animal {

    private boolean sleep;

    public Cat(String name, int age) {
        super(name, age);
    }
    
    public boolean getsleep() {
        return sleep;
    }

    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }
    
    public String makeSound() {
        return "Мяу";
    }

    public String catchMouse() {
        return "Поймал мышь";
    }
}
