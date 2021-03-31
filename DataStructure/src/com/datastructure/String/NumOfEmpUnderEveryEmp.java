/*
Given a dictionary that contains mapping of employee and his manager as a number of (employee, manager) pairs like below.
{ "A", "C" },
{ "B", "C" },
{ "C", "F" },
{ "D", "E" },
{ "E", "F" },
{ "F", "F" }

In this example C is manager of A,
C is also manager of B, F is manager
of C and so on.

Write a function to get no of employees under each manager in the hierarchy not just their direct reports. It may be assumed that an employee directly reports to only one manager. In the above dictionary the root node/ceo is listed as reporting to himself.

Output should be a Dictionary that contains following.

A - 0
B - 0
C - 2
D - 0
E - 1
F - 5

1. Create a reverse map with Manager->DirectReportingEmployee
    combination. Off-course employee will be multiple so Value
    in Map is List of Strings.
        "C" --> "A", "B",
        "E" --> "D"
        "F" --> "C", "E", "F"


2. Now use the given employee-manager map to iterate  and at
   the same time use newly reverse map to find the count of
   employees under manager.

   Let the map created in step 2 be 'mngrEmpMap'
   Do following for every employee 'emp'.
     a) If 'emp' is not present in 'mngrEmpMap'
          Count under 'emp' is 0 [Nobody reports to 'emp']
     b) If 'emp' is present in 'mngrEmpMap'
          Use the list of direct reports from map 'mngrEmpMap'
          and recursively calculate number of total employees
          under 'emp'.
*/

package com.datastructure.String;

import java.util.*;

public class NumOfEmpUnderEveryEmp {

    static void countNumOfEmployeeUnderEveryEmployee(Map<String,String> map){
        Map<String, List<String>> stringListMap = new HashMap<>();
        Map<String,Integer> EmpCount = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        map.forEach((k,v) -> {
            if(!k.equals(v)){
                List<String> stringList = stringListMap.getOrDefault(v,new ArrayList<>());
                stringList.add(k);
                stringListMap.put(v,stringList);
            }
        });

        map.forEach((k,v) -> {
            queue.add(k);
            int count = 0;

            while(!queue.isEmpty()) {
                String keyObject = queue.poll();
                if (EmpCount.containsKey(keyObject)) {
                    count += EmpCount.get(keyObject);
                } else {
                    if (stringListMap.containsKey(keyObject)) {
                        count += stringListMap.get(keyObject).size();
                        for (int i = 0; i < stringListMap.get(keyObject).size(); i++) {
                            queue.add(stringListMap.get(keyObject).get(i));
                        }
                    }
                }
            }
            EmpCount.put(k,count);
        });
        EmpCount.forEach((k,v)->System.out.println(k+" - "+v));
    }

    public static void main(String[] a){
        Map<String,String> map = new HashMap<>();
        map.put("A", "C");
        map.put("B", "C");
        map.put("C", "F");
        map.put("D", "E");
        map.put("E", "F");
        map.put("F", "F");
        countNumOfEmployeeUnderEveryEmployee(map);
    }
}
