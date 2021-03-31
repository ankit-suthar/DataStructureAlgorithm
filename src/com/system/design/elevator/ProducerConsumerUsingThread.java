package com.system.design.elevator;

import java.util.LinkedList;

public class ProducerConsumerUsingThread {

    public static void main(String[] a){
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        t1.setName("Consumer-1");
        t2.setName("Producer-1");
        t2.start();
        t1.start();
    }
}

class ProducerConsumer{
    LinkedList<Integer> linkedList = new LinkedList<>();
    int capacity = 2;

    public synchronized void producer() throws InterruptedException {
        int value=0;

        while(true){
            synchronized (this){

                //while(linkedList.size()==capacity){
                if(linkedList.size()==capacity){
                    wait();
                }

                System.out.println(Thread.currentThread().getName()+": Producer produced: "+value);
                linkedList.add(value++);
                notifyAll();
                Thread.sleep(1000);
            }
        }
    }

    public synchronized void consumer() throws InterruptedException {
        while(true){
            synchronized (this){

                //while(linkedList.size()==0){
                if(linkedList.size()==0){
                    wait();
                }

                System.out.println(Thread.currentThread().getName()+": Consumer consumed: "+linkedList.removeFirst());
                notifyAll();
                //Thread.sleep(1000);
            }
        }
    }
}
