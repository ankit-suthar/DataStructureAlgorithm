package com.system.design.elevator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] a){
        ElevatorImpl elevator = new ElevatorImpl(10,-2);



        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                Scanner stdin = new Scanner(new BufferedInputStream(System.in));
                String line;
                while(stdin.hasNext()){
                    String[] tokens = stdin.nextLine().split(" ");
                    if(tokens.length == 3 && tokens[0].equals("call")){
                        elevator.call(new Request(System.currentTimeMillis(),Integer.parseInt(tokens[1]), tokens[2].equals("up")?Direction.UP:Direction.DOWN));
                    }else if(tokens.length == 2 && tokens[0].equals("go")){
                        elevator.go(Integer.parseInt(tokens[1]));
                    }else{
                        System.out.println("Wrong input");
                    }
                    //System.out.println("Input: "+ Arrays.asList(tokens));
                }
                    /*while (true) {
                        if ((line = reader.readLine()) != null) {
                            String[] tokens = line.split(" ");
                            if(tokens.length == 3 && tokens[0].equals("call")){
                                elevator.call(new Request(System.currentTimeMillis(),Integer.parseInt(tokens[1]), tokens[2].equals("up")?Direction.UP:Direction.DOWN));
                            }else if(tokens.length == 2 && tokens[0].equals("go")){
                                elevator.go(Integer.parseInt(tokens[1]));
                            }else{
                                System.out.println("Wrong input");
                            }
                        }
                    }*/
            }
        });
        t1.setName("Suthar");
        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                elevator.process();
            }
        });
        t.setName("Ankit");
        t.start();
    }
}
