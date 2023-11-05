package ru.gbhw.java.philosophers;

import java.util.ArrayList;

public class Philosophers {
    public volatile static ArrayList<Boolean> eatList = new ArrayList<>();
    private ArrayList<Philosopher> phList = new ArrayList<>();
    
    public Philosophers(String[] names, int timeEat, int delta, int maxEat){
        for(int element = 0; element < names.length; element++){
            eatList.add(false);
            phList.add(new Philosopher(element, (timeEat + (element * delta)), names[element], maxEat));
        }
    }

    public void beg(){
        for(Philosopher philosopher : phList){
            philosopher.start();
        }
    }

    public static synchronized boolean getNeighbours(int id, int side){
        if (id == 0 && side == -1)
            return eatList.get(eatList.size() + side);
        else if (side == 1 && (id + side) == eatList.size())
            return eatList.get(0);
        else
            return eatList.get(id + side);
    }

    public static synchronized void setEat(int id, boolean action) {
        eatList.set(id, action);
    }
}
