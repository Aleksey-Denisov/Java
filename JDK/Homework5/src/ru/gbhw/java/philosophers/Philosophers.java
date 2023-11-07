package ru.gbhw.java.philosophers;

import java.util.ArrayList;

public class Philosophers {
    public volatile static ArrayList<Boolean> eatList = new ArrayList<>();
    private ArrayList<Philosopher> phList = new ArrayList<>();
    
    public Philosophers(String[] names, int timeEat, int delta, int maxEat) {
        for(int element = 0; element < names.length; element++){
            eatList.add(false);
            phList.add(new Philosopher(element, (timeEat + (element * delta)), names[element], maxEat));
        }
    }

    public void beg() {
        for(Philosopher philosopher : phList){
            philosopher.start();
        }
    }

    public static synchronized boolean getNeighbours(int id, boolean justEat) {
        boolean flag = true;
        if(justEat)
            return justEat;
        if (id == 0)
            flag = (eatList.get(eatList.size() - 1) | eatList.get(id + 1));
        else if ((id + 1) == eatList.size())
            flag = (eatList.get(0) | eatList.get(id - 1));
        else
            flag = (eatList.get(id + 1) | eatList.get(id - 1));
        if(!flag)
            eatList.set(id, !flag);
        return flag;
    }

    public static synchronized void setEat(int id) {
        eatList.set(id, false);
    }
}
