package com.datastructure.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    class SortArray{
        int arrIndex;
        int index;
        int val;

        public SortArray(int arrIndex,int index,int val){
            this.arrIndex=arrIndex;
            this.index=index;
            this.val=val;
        }
    }

    class myComparator implements Comparator<SortArray>{
        @Override
        public int compare(SortArray o1, SortArray o2) {
            if(o1.val>o2.val){
                return 1;
            }else if(o1.val<o2.val){
                return -1;
            }else{
                return 0;
            }
        }
    }

    void mergeKSortedArrays(int arr[][],int n){
        PriorityQueue<SortArray> pq = new PriorityQueue<>(new myComparator());
        int k=0;

        for(int i=0;i<arr.length;i++){
            pq.add(new SortArray(i,0,arr[i][0]));
            k+=arr[i].length;
        }

        int ans[] = new int[k];
        int index=0;
        SortArray obj;
        int objIndex;

        while(!pq.isEmpty()){
            obj = pq.poll();
            ans[index] = obj.val;
            obj.index++;
            if(obj.index<arr[obj.arrIndex].length){
                obj.val = arr[obj.arrIndex][obj.index];
                pq.add(obj);
            }
            index++;
        }

        for(int i=0;i<k;i++){
            System.out.print(ans[i]+" ");
        }
    }

    /*class QueueObject{
        int data;
        int arrIndex;
        int index;

        public QueueObject(int data,int arrIndex,int index){
            this.data = data;
            this.arrIndex = arrIndex;
            this.index = index;
        }
    }

    void mergeKSortedArrays(int[][] arr,int n){
        PriorityQueue<QueueObject> pq = new PriorityQueue<>((q1, q2) -> {
            if(q1.data>q2.data){
                return 1;
            }else if(q1.data<q2.data){
                return -1;
            }else{
                return 0;
            }
        });
        int m=0;

        for(int i=0;i<n;i++){
            m += arr[i].length;
            pq.add(new QueueObject(arr[i][0],i,0));
        }

        int ans[] = new int[m];
        int j=0;

        while(!pq.isEmpty()){
            QueueObject q = pq.poll();

            ans[j] = q.data;
            j++;

            int arrIndex = q.arrIndex;
            int index = q.index;
            index++;
            if(index < arr[arrIndex].length){
                pq.add(new QueueObject(arr[arrIndex][index],arrIndex,index));
            }
        }
        Arrays.stream(ans).forEach(e->System.out.print(e+" "));
    }*/


    public static void main(String[] a){
        MergeKSortedArrays mergeKSortedArrays = new MergeKSortedArrays();
        int[][] arr= {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};

        System.out.println("Merged array is :");

        mergeKSortedArrays.mergeKSortedArrays(arr,arr.length);
    }
}
