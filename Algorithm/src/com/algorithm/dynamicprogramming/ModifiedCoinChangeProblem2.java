package com.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class ModifiedCoinChangeProblem2 {

    static int MAX_COIN = 4;
    static List<List<Integer>> listOfList = new ArrayList<>();

    static int count(int arr[],int n,int sum,int index,List<Integer> change){

        if(sum==0 && change.size()<=MAX_COIN){
            listOfList.add(new ArrayList<>(change));
            return 1;
        }

        if(sum==0 && change.size()>MAX_COIN){
            return 0;
        }

        if(sum<0){
            return 0;
        }

        if(n<=0 && sum>=1){
            return 0;
        }

        change.add(index,arr[n-1]);

        int result1 = count(arr,n,sum-arr[n-1],index+1,change);
        change.remove(index);
        int result2 = count(arr,n-1,sum,index,change);
        return result1 + result2;
    }

    public static void main(String[] a){
        int arr[] = {1, 3, 4, 5, 20, 30, 40, 50, 100};
        //int arr[] = {3, 4, 5, 30, 40};
        int n = arr.length;
        int itemAmount = 23;
        int moneyPaid = 100;
        int changeAmount = moneyPaid - itemAmount;
        List<Integer> change = new ArrayList<>();

        if(changeAmount>0){
            System.out.println(count(arr, n, changeAmount,0,change));
        }else{
            System.out.println("No change require");
        }
        System.out.println(listOfList);
    }
}
