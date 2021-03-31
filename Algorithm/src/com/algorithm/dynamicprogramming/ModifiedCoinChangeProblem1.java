/*
This code is the implementation of the Vending Machine problem for change amount from given set of change,
while making payment more than the cost of an item.
*/
package com.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class ModifiedCoinChangeProblem1 {

    public final static int MAX_COIN = 4;

    static void countChange(int arr[],int arrayLength,int changeAmount
                            ,int index,List<Integer> changeList,List<List<Integer>> listOfList){

        if(changeAmount==0 && changeList.size()<=MAX_COIN){
            listOfList.add(new ArrayList<>(changeList));
            return;
        }

        if(changeAmount==0 && changeList.size()>MAX_COIN){
            return;
        }

        if(changeAmount<0){
            return;
        }

        if(arrayLength<=0 && changeAmount>=1){
            return;
        }

        changeList.add(index,arr[arrayLength-1]);

        countChange(arr,arrayLength,changeAmount-arr[arrayLength-1],index+1,changeList,listOfList);
        changeList.remove(index);
        countChange(arr,arrayLength-1,changeAmount,index,changeList,listOfList);
    }

    public static void main(String[] a){
        //initializing array
        //int arr[] = {1, 3, 4, 5, 20, 30, 40, 50, 100}; // [50, 20, 4, 3], [40, 30, 4, 3]
        int arr[] = {1, 3, 4, 5, 10, 30, 40, 50, 100}; // [40, 30, 4, 3]
        //int arr[] = {1,2,3}; // No change
        //int arr[] = {1000}; // No change
        //int arr[] = {}; // Invalid input
        //int arr[] = null; // Invalid input

        /*
            Assumption:
                        1) We are initializing 'arr' with either 'null' or 'empty' array in worst case
                        2) Initializing MAX_COIN at class level, this variable we can be accepted as user input and passed to function call
        */

        // array length
        int arrayLength;

        // Cost of an item
        int itemAmount = 23;

        // Money paid for the item
        int moneyPaid = 100;

        // After cost of an item, how much change have to be returned
        int changeAmount = moneyPaid - itemAmount;

        // List to store changed
        List<Integer> change = new ArrayList<>();

        // List to store list of valid changes
        List<List<Integer>> listOfList = new ArrayList<>();

        //base conditions
        if(arr == null || arr.length == 0){
            System.out.println("~~~~~~~~~~~~~");
            System.out.println("Invalid input");
            System.out.println("~~~~~~~~~~~~~");
        }else if(itemAmount<0){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Item amount can't be negative");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }else if(itemAmount==0){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Enjoy product free of cost!! Yooooo");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }else if(moneyPaid<=0){
            System.out.println("~~~~~~~~~~~~~~~");
            System.out.println("Invalid payment");
            System.out.println("~~~~~~~~~~~~~~~");
        }else if(moneyPaid<itemAmount){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("you can't buy this product");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }else {
            // array length
            arrayLength = arr.length;

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("CONSIDERING CURRENCY INTO UNIT");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();

            // If change amount is greater than 0 then only check for change, else no change
            if(changeAmount>0){
                countChange(arr, arrayLength, changeAmount,0,change,listOfList);
                if(listOfList.size()==0){
                    System.out.println("Vendor doesn't have change of: "+changeAmount+" Unit");
                }else {
                    System.out.println("Vendor has below combination of change for: "+changeAmount+" Unit");
                    System.out.println(listOfList);
                }
            }
            // In the case of no change, below message will be printed
            else{
                System.out.println("No change require");
            }
        }
    }
}
