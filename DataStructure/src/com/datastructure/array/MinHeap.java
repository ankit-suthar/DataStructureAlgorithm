package com.datastructure.array;

public class MinHeap {

    int maxSize;
    int Heap[];
    int size;

    public MinHeap(int maxSize) {
        this.maxSize=maxSize;
        Heap = new int[maxSize+1];
        Heap[0] = Integer.MIN_VALUE;
        size=0;
    }

    void insert(int data){
        if(size == maxSize){
            return;
        }

        Heap[++size] = data;
        int curr = size;

        while(Heap[curr] < Heap[curr/2]){
            swap(curr);
            curr = curr/2;
        }
    }

    void swap(int pos){
        int temp = Heap[pos];
        Heap[pos] = Heap[pos/2];
        Heap[pos/2] = temp;
    }

    void heapify(int pos){
        int i=pos;
        int l = pos*2;
        int r = pos*2+1;

        if(l<=size && Heap[l]<Heap[i]){
            i=l;
        }

        if(r<=size && Heap[r]<Heap[i]){
            i=r;
        }

        if(i!=pos){
            swap(i);
            heapify(i);
        }
    }

    void minHeap(){
        for(int i=(size/2);i>0;i--){
            heapify(i);
        }
    }

    int remove(){
        int val=-1;
        if(size>0){
            val=Heap[1];
            Heap[1] = Heap[size];
            size--;
            heapify(1);
        }
        return val;
    }

    void print(){
        for(int i=1;i<=size;i++){
            System.out.print(Heap[i]+" ");
        }
    }

    public static void main(String[] a){
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();
        minHeap.print();
        System.out.println();
        System.out.println("The Min val is " + minHeap.remove());
        minHeap.print();
        System.out.println();
        System.out.println("The Min val is " + minHeap.remove());
        minHeap.print();
        System.out.println();
        System.out.println("The Min val is " + minHeap.remove());
        minHeap.print();
        System.out.println();
        System.out.println("The Min val is " + minHeap.remove());
        minHeap.print();
        System.out.println();
        System.out.println("The Min val is " + minHeap.remove());
        minHeap.print();
        System.out.println();
        System.out.println("The Min val is " + minHeap.remove());
        minHeap.print();
        System.out.println();
        System.out.println("The Min val is " + minHeap.remove());
        minHeap.print();
        System.out.println();
        System.out.println("The Min val is " + minHeap.remove());
        minHeap.print();
        System.out.println();
        System.out.println("The Min val is " + minHeap.remove());
        minHeap.print();
        System.out.println();
        System.out.println("The Min val is " + minHeap.remove());
        minHeap.print();
    }
}
