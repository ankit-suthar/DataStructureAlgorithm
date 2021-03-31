package com.company.question.amazon;

import java.util.ArrayList;
import java.util.*;

public class AmazonTest {

    class ObjectTemp{
        String name;
        int count;

        public ObjectTemp(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ObjectTemp that = (ObjectTemp) o;
            return name.equals(that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    class MyComparator implements Comparator<ObjectTemp>{

        @Override
        public int compare(ObjectTemp o1, ObjectTemp o2) {
            if(o1.getCount()>o2.getCount()){
                return -1;
            }else if(o1.getCount()<o2.getCount()){
                return 1;
            }else{
                return o1.getName().compareTo(o2.getName());
            }
        }
    }

    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests)
    {
        HashSet<ObjectTemp> set = new HashSet<>();

        for(int i=0;i<featureRequests.size();i++){
            String str = featureRequests.get(i);

            for(int j=0;j<possibleFeatures.size();j++) {

                if(str.contains(possibleFeatures.get(j))){
                    ObjectTemp temp = new ObjectTemp(possibleFeatures.get(j),1);
                    if (set.contains(temp)) {
                        ObjectTemp ot1 = null;
                        for (ObjectTemp ot : set) {
                            if (ot.equals(temp)) {
                                ot1 = ot;
                                break;
                            }
                        }
                        int countVar = ot1.getCount();
                        countVar++;
                        ot1.setCount(countVar);
                        set.add(ot1);
                    }else{
                        ObjectTemp ot = new ObjectTemp(possibleFeatures.get(j),1);
                        set.add(ot);
                    }
                }

            }
        }

        int count=0;
        ArrayList<String> ans = new ArrayList<>();
        PriorityQueue<ObjectTemp> pq = new PriorityQueue<ObjectTemp>(new MyComparator());

        for(ObjectTemp ot:set){
            pq.add(ot);
        }

        while(!pq.isEmpty()){
            ObjectTemp ot = pq.poll();
            ans.add(ot.getName());
            count++;
            if(count==topFeatures){
                break;
            }
        }
        return ans;
    }

    public static void main(String[] a){
        AmazonTest amazonTest = new AmazonTest();
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
