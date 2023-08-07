package ru.gbhw.java.module;

import java.util.HashMap;
import java.util.Map;

public class State {
    private Map<Integer, String> state = new HashMap<>();
    public State(){
        state.put(0, ".");
        state.put(1, "x");
        state.put(2, "0");
        state.put(3, "?");
    }
    public String getState(int key){
        return state.get(key);
    }
}
