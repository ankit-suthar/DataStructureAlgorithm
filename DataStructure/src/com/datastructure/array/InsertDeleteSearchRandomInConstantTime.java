/*
Design a data structure that supports following operations in Θ(1) time.

insert(x): Inserts an item x to the data structure if not already present.

remove(x): Removes an item x from the data structure if present.

search(x): Searches an item x in the data structure.

getRandom(): Returns a random element from current set of elements

insert(x)
1) Check if x is already present by doing a hash map lookup.
2) If not present, then insert it at the end of the array.
3) Add in hash table also, x is added as key and last array index as index.

remove(x)
1) Check if x is present by doing a hash map lookup.
2) If present, then find its index and remove it from hash map.
3) Swap the last element with this element in array and remove the last element.
Swapping is done because the last element can be removed in O(1) time.
4) Update index of last element in hash map.

getRandom()
1) Generate a random number from 0 to last index.
2) Return the array element at the randomly generated index.

search(x)
Do a lookup for x in hash map.
*/
package com.datastructure.array;

import java.util.*;

public class InsertDeleteSearchRandomInConstantTime {

    List<Integer> list;
    Map<Integer,Integer> map;

    public InsertDeleteSearchRandomInConstantTime() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    void insertData(int data){
        if(!map.containsKey(data)){
            list.add(data);
            map.put(data,list.size()-1);
        }
    }

    int searchData(int data){
        if(map.containsKey(data)){
            return map.get(data);
        }
        return -1;
    }

    void deleteData(int data){
        if(map.containsKey(data)){
           int idx = map.get(data);
           int lastIdx = list.size()-1;
           int lastValue = list.get(lastIdx);
           list.set(idx,lastValue);
           list.set(lastIdx,data);
           list.remove(lastIdx);
           map.remove(data);
           map.put(lastValue,idx);
        }
    }

    int getRandomData(){
        Random rand = new Random();
        int randIdx =  rand.nextInt(list.size());
        return list.get(randIdx);
    }

    public static void main(String[] args){
        InsertDeleteSearchRandomInConstantTime op = new InsertDeleteSearchRandomInConstantTime();
        op.insertData(10);
        op.insertData(20);
        op.insertData(30);
        op.insertData(40);
        System.out.println("Index: "+op.searchData(30));
        op.deleteData(20);
        op.insertData(50);
        System.out.println("Index: "+op.searchData(50));
        System.out.println("Random Data: "+op.getRandomData());
    }
}
//Time Complexity: O(1)