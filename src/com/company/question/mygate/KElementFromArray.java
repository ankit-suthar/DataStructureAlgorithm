package com.company.question.mygate;

public class KElementFromArray {

    static void hepify(int[] arr,int arrayLength,int index){
        int newIndex = index;
        int left = 2*newIndex + 1;
        int right = 2*newIndex + 2;

        if(left<arrayLength && arr[newIndex]<arr[left]){
            newIndex = left;
        }

        if(right<arrayLength && arr[newIndex]<arr[right]){
            newIndex = right;
        }

        if(newIndex != index){
            int temp = arr[newIndex];
            arr[newIndex] = arr[index];
            arr[index] = temp;
            hepify(arr,arrayLength,newIndex);
        }
    }

    static void sort(int[] arr,int arrayLength,int noOfElements){

        for(int index = arrayLength/2-1;index >= 0;index--){
            hepify(arr,arrayLength,index);
        }

        for(int index = arrayLength-1;index >= 0;index--){
            System.out.print(arr[0]+" ");

            int tempVar = arr[0];
            arr[0] = arr[index];
            arr[index] = tempVar;

            hepify(arr,index,0);

            noOfElements--;
            if(noOfElements<1){
                break;
            }
        }
    }

    public static void main(String[] a){
        int arr[] = {10,15,5,10,25,6,5,30,2,15};
        int arrayLength = arr.length;
        // # of elements want to retrieve
        int noOfElements = 3;
        sort(arr,arrayLength,noOfElements);
    }
}
//Time Complexity: k log n
