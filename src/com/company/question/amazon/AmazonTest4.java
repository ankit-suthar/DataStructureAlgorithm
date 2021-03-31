package com.company.question.amazon;

import java.util.*;

public class AmazonTest4 {

    class MyComparator implements Comparator<Map.Entry<String,Integer>>{

        @Override
        public int compare(Map.Entry<String,Integer> entry1, Map.Entry<String,Integer> entry2) {
            if(entry1.getValue()>entry2.getValue()){
                return -1;
            }else if(entry1.getValue()<entry2.getValue()){
                return 1;
            }else{
                return entry1.getKey().compareTo(entry2.getKey());
            }
        }
    }

    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests)
    {
        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<featureRequests.size();i++){
            String str = featureRequests.get(i);

            for(int j=0;j<possibleFeatures.size();j++) {

                if(str.contains(possibleFeatures.get(j))){
                    Integer count = map.getOrDefault(possibleFeatures.get(j),0);
                    count++;
                    map.put(possibleFeatures.get(j),count);
                }
            }
        }

        Set<Map.Entry<String,Integer>> set = map.entrySet();
        List<Map.Entry<String,Integer>> list = new ArrayList<>(set);
        Collections.sort(list,new MyComparator());

        ArrayList<String> ans = new ArrayList<>();

        for(int i=0;i<topFeatures;i++){
            ans.add(list.get(i).getKey());
        }

        return ans;
    }

    public static void main(String[] a){
        AmazonTest4 amazonTest = new AmazonTest4();
        //int numFeatures =5;
        int numFeatures =6;
        int topFeatures =2;
        String possibleFeatures[] = new String[]{"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        //String possibleFeatures[] = new String[]{"storage", "battery", "hover", "alexa", "waterproof", "solar"};
        int numFeatureRequests = 5;
        String featureRequests[] = new String[]{"I love anacell Best services provided by anacell in the town", "betacellular has great services",
                "deltacellular provides much better services than betacellular", "cetracular is worse than eurocell",
                "betacellular is better than deltacellular"};
        /*String featureRequests[] = new String[]{"Best services provided by anacell", "betacellular has great services",
                "anacell provides much better services than all other"};*/
        /*String featureRequests[] = new String[]{"I wish my Kindle had even more storage!", "I wish the battery life on my Kindle lasted 2 years.",
                "I read in the bath and would enjoy a waterproof Kindle", "Waterproof and increased battery are my top two requests.",
                "I want to take my Kindle into the shower. Waterproof please waterproof !",
                "It would be neat if my Kindle would hover on my desk when not in use.",
                "How cool would it be if my Kindle charged in the sun via solar power?"};*/

        List<String> ans = amazonTest.popularNFeatures(numFeatures,topFeatures,Arrays.asList(possibleFeatures),numFeatureRequests,Arrays.asList(featureRequests));
        System.out.println(ans);
    }
}
