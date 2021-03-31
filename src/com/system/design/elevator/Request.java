package com.system.design.elevator;

public class Request {

    private long time;
    private Integer floorNo;
    private Direction direction;

    public Request(long time, int floorNo, Direction direction) {
        this.time = time;
        this.floorNo = floorNo;
        this.direction = direction;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Request{" +
                "time=" + time +
                ", floorNo=" + floorNo +
                ", direction=" + direction +
                '}';
    }
}
