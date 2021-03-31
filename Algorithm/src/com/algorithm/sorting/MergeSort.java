package com.algorithm.sorting;

public class MergeSort {

    void mergeSort(int arr[],int l,int mid,int h){
        int n1 = mid-l+1;
        int n2 = h-mid;
        int L[] = new int[n1];
        int R[] = new int[n2];

        int k = l;

        for(int i=0;i<n1;i++){
            L[i] = arr[l+i];
        }

        for(int j=0;j<n2;j++){
            R[j] = arr[mid+1+j];
        }

        int i=0,j=0;

        while(i<n1 && j<n2){
            if(L[i]<R[j]){
                arr[k]=L[i];
                i++;
            }else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }

    void sort(int[] arr,int l,int h){
        if(l<h){
            int mid = (l+h)/2;
            sort(arr,l,mid);
            sort(arr,mid+1,h);

            mergeSort(arr,l,mid,h);
        }
    }

    void printArray(int arr[],int n){
        for (int i:arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] a){
        MergeSort mergeSort = new MergeSort();
        int arr[] = {3,6,5,8,9,7};
        int n = arr.length;
        System.out.println("Array before sorting: ");
        mergeSort.printArray(arr,arr.length);
        mergeSort.sort(arr,0,arr.length-1);
        System.out.println("Array after sorting: ");
        mergeSort.printArray(arr,arr.length);
    }
}
//Time complexity of Merge Sort: n(log n)
//Auxiliary Space: O(n)
//Algorithmic Paradigm: Divide and Conquer
//Sorting In Place: No in a typical implementation