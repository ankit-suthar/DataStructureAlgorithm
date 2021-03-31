package com.datastructure.array;

public class StockSpanProblemMthd2 {

    static void calculateSpan(int[] price,int n,int[] span){
        int count;
        span[0]=1;

        for(int i=1;i<n;i++){
            count=1;
            while((i-count)>=0 && price[i]>price[i-count]){
                count++;
            }
            span[i] = count;
        }

        for(int index:span){
            System.out.print(index+" ");
        }
    }

    public static void main(String[] a){
        int price[] = { 10, 4, 5, 90, 120, 80 };
        int n = price.length;
        int[] span = new int[n];

        calculateSpan(price,n,span);
    }
}
