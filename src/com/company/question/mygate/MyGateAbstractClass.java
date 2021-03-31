package com.company.question.mygate;

abstract class Car{
    private Boolean isSedan;
    private String seats;

    public Car(Boolean isSedan, String seats) {
        this.isSedan = isSedan;
        this.seats = seats;
    }

    public Boolean getSedan() {
        return isSedan;
    }

    public String getSeats() {
        return seats;
    }

    abstract int getMileage();
}

class WagonR extends Car{

    public WagonR() {
        super(false,"4");
    }

    @Override
    int getMileage() {
        return 15;
    }
}

class HondaCity extends Car{

    public HondaCity() {
        super(true,"4");
    }

    @Override
    int getMileage() {
        return 18;
    }
}

class InnovaCrysta extends Car{

    public InnovaCrysta() {
        super(false,"6");
    }

    @Override
    int getMileage() {
        return 20;
    }
}

public class MyGateAbstractClass {

    public static void main(String []a){
        Car car = new WagonR();
        System.out.println(car.getMileage());
        car = new HondaCity();
        System.out.println(car.getMileage());
        car = new InnovaCrysta();
        System.out.println(car.getMileage());
    }
}
