package com.system.design.elevator;

public abstract class Elevator {

    int maxFloor;
    int minFloor;
    //int status;

    public Elevator(int maxFloor, int minFloor) {
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
    }

    abstract void call(Request request);
}
