/*
A Juggling Algorithm)
This is an extension of method 2. Instead of moving one by one, divide the array in different sets
where number of sets is equal to GCD of n and d and move the elements within sets.
If GCD is 1 as is for the above example array (n = 7 and d =2), then elements will be
moved within one set only, we just start with temp = arr[0] and keep moving arr[I+d] to arr[I] and finally store temp at the right place.

Here is an example for n =12 and d = 3. GCD is 3 and

Let arr[] be {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}

a) Elements are first moved in first set – (See below
   diagram for this movement)

ArrayRotation

          arr[] after this step --> {4 2 3 7 5 6 10 8 9 1 11 12}

b)    Then in second set.
          arr[] after this step --> {4 5 3 7 8 6 10 11 9 1 2 12}

c)    Finally in third set.
          arr[] after this step --> {4 5 6 7 8 9 10 11 12 1 2 3}

*/
package com.datastructure.array;

public class ArrayRotationMthd2 {

    static void rotateArray(int[] arr,int n,int d){
        int gcd = getGcd(n,d);
        int j, k, temp;

        for(int i=0;i<gcd;i++){
            temp = arr[i];
            j = i;

            while (true){
                k = j+d;
                if(k>=n){
                    k = k-n;
                }
                if(k==i){
                    break;
                }
                arr[j] = arr[k];
                j=k;
            }
            arr[j] = temp;
        }
    }

    static int getGcd(int a,int b){
        if(b==0){
            return a;
        }else{
            return getGcd(b,a%b);
        }
    }

    static void printArray(int[] arr){
        for(int ele:arr){
            System.out.print(ele+" ");
        }
    }

    public static void main(String[] a){
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int n = arr.length;
        int d = 5;
        printArray(arr);
        rotateArray(arr,n,d);
        System.out.println();
        printArray(arr);
    }
}
//Time complexity : O(n)
//Auxiliary Space : O(1)