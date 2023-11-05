package ru.gbhw.java.philosophers;

public class Philosopher extends Thread {
    private int id, countEat = 0, timeEat;
    private String name;
    private int maxEat;
    private boolean justEat = false;

    public Philosopher(int id, int timeEat, String name, int maxEat) {
        this.id = id;
        this.timeEat = timeEat;
        this.name = name;
        this.maxEat = maxEat;
    }

    @Override
    public void run() {
        try{
            while(countEat < maxEat) {
                if(!getNeighbours(-1) && !getNeighbours(1) && !justEat){
                    countEat++;
                    setEat(true);
                    System.out.println(name + " взял правую и взял левую вилки");
                    System.out.println(name + " начал трапезу");
                    sleep(timeEat);
                    setEat(false);
                    System.out.println(name + " положил обе вилки");
                    justEating(true);
                }
                else{
                    System.out.println(name + " думает");
                    sleep(timeEat);
                    justEating(false);
                }
            }
            System.out.println(id + " " + name + " наелся");
        }
        catch(InterruptedException  e) {
            e.getMessage();
        }
    }

    private boolean getNeighbours(int side) {
       return Philosophers.getNeighbours(id, side);
    }

    private void setEat(boolean action) {
        Philosophers.setEat(id, action);
    }

    private void justEating(boolean action){
        justEat = action;
    }
}
