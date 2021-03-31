package com.datastructure.array;

public class RainWaterTrappingMthd2 {

    static int rainWaterTrapping(int[] arr,int n){
        int i=0,j=n-1;
        int lo=0;
        int hi=0;
        int totalWater=0;

        while(i<=j){
            if(arr[i]<=arr[j]){
                if(lo>arr[i]){
                    totalWater += lo-arr[i];
                }else{
                    lo=arr[i];
                }
                i++;
            }else{
                if(hi>arr[j]){
                    totalWater += hi-arr[j];
                }else{
                    hi=arr[j];
                }
                j--;
            }
        }

        return totalWater;
    }

    public static void main(String[] a){
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }; //6
        //int arr[] = {2, 0, 2}; //2
        //int arr[] = {3, 0, 0, 2, 0, 4}; //10
        int n = arr.length;
        int totalWaterLevel = rainWaterTrapping(arr,n);
        System.out.println(totalWaterLevel);
    }
}
//Time Complexity: O(n)
//Auxiliary Space: O(1)