package ru.gbhw;

public class MontyHall {
    private int prizeId, choisePlayer, openDoorId;

    public MontyHall(int prizeId){
        this.prizeId = prizeId;
    }

    public int getPrizeId() {
        return prizeId;
    }

    public int getChoisePlayer() {
        return choisePlayer;
    }

    public void setChoisePlayer(int choisePlayer) {
        this.choisePlayer = choisePlayer;
    }

    public int getOpenDoorId() {
        return openDoorId;
    }
    
    public void setOpenDoorId(int openDoorId) {
        this.openDoorId = openDoorId;
    }
}
