package com.system.design.elevator;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class ElevatorImpl extends Elevator {

    PriorityQueue<Request> upQueue = new PriorityQueue<>(new Comparator<Request>() {
        @Override
        public int compare(Request r1, Request r2) {
            int val1 = r1.getFloorNo();
            int val2 = r2.getFloorNo();
            if(val1<val2){
                return -1;
            }else if(val1>val2){
                return 1;
            }else{
                return 0;
            }
        }
    });
    PriorityQueue<Request> downQueue = new PriorityQueue<>(new Comparator<Request>() {
        @Override
        public int compare(Request r1, Request r2) {
            int val1 = r1.getFloorNo();
            int val2 = r2.getFloorNo();
            if(val1<val2){
                return -1;
            }else if(val1>val2){
                return 1;
            }else{
                return 0;
            }
        }
    }.reversed());
    PriorityQueue<Request> currentQueue = upQueue;
    int currentMaxFloor;
    int currentMinFloor;
    int location;
    private Direction direction = Direction.UP;
    private State state = State.STOPPED;
    private Door door = Door.CLOSED;

    public ElevatorImpl(int maxFloor, int minFloor) {
        super(maxFloor, minFloor);
        /*currentMaxFloor=0;
        currentMinFloor=0;*/
        //direction = Direction.NONE;
    }

    @Override
    void call(Request request/*int floorNo, Direction direction*/) {
        synchronized (this){
            if(Direction.UP == direction){
                if(request.getFloorNo() >= location){
                    //processQueue(currentQueue,request,"Add");
                    currentQueue.add(request);
                }else{
                    downQueue.add(request);
                    //processQueue(downQueue,request,"Add");
                }
            }else {
                if(request.getFloorNo() <= location){
                    currentQueue.add(request);
                }else{
                    upQueue.add(request);
                }
            }
            System.out.println(Thread.currentThread().getName()+" -> "+location+" "+request+" "+upQueue.size()+" "+downQueue.size());
        }
        notifyAll();
    }

    public void go(int floorNo){
        call(new Request(System.currentTimeMillis(),floorNo,direction));
    }

    public void goToFloor(int floor,Direction direction) {
        if(direction == Direction.UP){
            for(float i = location;i <= floor; i += 0.2 ){
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            location = floor;
            door = Door.OPEN;
            state = State.STOPPED;
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            door = Door.CLOSED;
            currentQueue.poll();
        }else{
            for(float i = location;i >= floor; i -= 0.2 ){
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            location = floor;
            door = Door.OPEN;
            state = State.STOPPED;
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            door = Door.CLOSED;
        }
    }

    public Request processQueue(PriorityQueue<Request> queue,Request request,String str){
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        Request r = null;
        try{
            if(str.equals("Add")){
                queue.add(request);
            }else{
                r = queue.poll();
            }
        }finally {
            reentrantLock.unlock();
        }
        return r;
    }

    public void process(){
        while(true){
            if(!upQueue.isEmpty() || !downQueue.isEmpty()){
                Request request = currentQueue.poll();
                if(request!=null){
                    System.out.println("Serving--> "+request);
                    goToFloor(request.getFloorNo(),request.getDirection());
                }else{
                    System.out.println("Here");
                    preProcessNextQueue();
                }
            }
        }
    }

    private void preProcessNextQueue(){
        long upTime = getLowestTimeUpQueue();
        long downTime = getLowestTimeDownQueue();

        if(upTime == Long.MAX_VALUE && downTime == Long.MAX_VALUE){
            direction = Direction.NONE;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if(upTime == Long.MAX_VALUE){
            direction = Direction.DOWN;
            currentQueue = downQueue;

        }else if(downTime == Long.MAX_VALUE){
            direction = Direction.UP;
            currentQueue = upQueue;

        }else if(upTime<downTime){
            direction = Direction.UP;
            currentQueue = upQueue;

        }else if(upTime>downTime){
            direction = Direction.DOWN;
            currentQueue = downQueue;
        }

    }

    public long getLowestTimeUpQueue(){
        long time = Long.MAX_VALUE;

        for(Request r : upQueue){
            if(r.getTime()<time){
                time = r.getTime();
            }
        }
        return time;
    }

    public long getLowestTimeDownQueue(){
        long time = Long.MAX_VALUE;

        for(Request r : downQueue){
            if(r.getTime()<time){
                time = r.getTime();
            }
        }
        return time;
    }

    public Queue<Request> getUpQueue() {
        return upQueue;
    }

    public Queue<Request> getDownQueue() {
        return downQueue;
    }

    public int getCurrentMaxFloor() {
        return currentMaxFloor;
    }

    public void setCurrentMaxFloor(int currentMaxFloor) {
        this.currentMaxFloor = currentMaxFloor;
    }

    public int getCurrentMinFloor() {
        return currentMinFloor;
    }

    public void setCurrentMinFloor(int currentMinFloor) {
        this.currentMinFloor = currentMinFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
