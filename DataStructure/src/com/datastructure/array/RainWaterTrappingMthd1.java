package com.datastructure.array;

public class RainWaterTrappingMthd1 {

    static int rainWaterTrapping(int arr[], int n){
        int left[] = new int[n];
        int right[] = new int[n];

        left[0]=arr[0];

        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1],arr[i]);
        }

        right[n-1]=arr[n-1];

        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1],arr[i]);
        }

        int totalWaterLevel=0;

        for(int i=0;i<n;i++){
            totalWaterLevel += Math.min(left[i],right[i])-arr[i];
        }

        return totalWaterLevel;
    }

    public static void main(String[] a){
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int n = arr.length;
        int totalWaterLevel = rainWaterTrapping(arr,n);
        System.out.println(totalWaterLevel);
    }
}
//Time Complexity: O(n)
//Auxiliary Space: O(n)