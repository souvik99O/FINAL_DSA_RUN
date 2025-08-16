class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer,Integer> fullMap= new HashMap<>();
        HashMap<Integer,Integer> b1Map= new HashMap<>();
        HashMap<Integer,Integer> b2Map= new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        int globalMin = Integer.MAX_VALUE;

        int n= basket1.length;
        for(int i=0; i<n ;i++){
            fullMap.put(basket1[i],fullMap.getOrDefault(basket1[i],0)+1);
            b1Map.put(basket1[i],b1Map.getOrDefault(basket1[i],0)+1);
            globalMin = Math.min(globalMin, basket1[i]);
        }

        for(int i=0; i<n ;i++){
            fullMap.put(basket2[i],fullMap.getOrDefault(basket2[i],0)+1);
            b2Map.put(basket2[i],b2Map.getOrDefault(basket2[i],0)+1);
            globalMin = Math.min(globalMin, basket2[i]);
        }

        for(Map.Entry<Integer,Integer> e: fullMap.entrySet())
        {
            if(e.getValue()<2)
            return -1;
        }

        Arrays.sort(basket1);
        Arrays.sort(basket2);
        List<Integer> list= new ArrayList<>();

        for(int i=0; i<basket1.length; i++)
        {
            if(i!=0 && basket1[i]==basket1[i-1])
            continue;
            if(b1Map.get(basket1[i]) != b2Map.get(basket1[i])){
                int totalFruits=fullMap.get(basket1[i]);
                int shouldBe=totalFruits/2;
                int fruitInB1 = b1Map.getOrDefault(basket1[i], 0);
                int fruitInB2 = b2Map.getOrDefault(basket1[i], 0);

                int fruitToEqualize=Math.abs(shouldBe-fruitInB1);
                
                for(int j=0; j<fruitToEqualize; j++)
                {
                    list.add(basket1[i]);
                    seen.add(basket1[i]);
                }
            }

        }


        for(int i=0; i<basket2.length; i++)
        {
            if(i!=0 && basket2[i]==basket2[i-1])
            continue;
            if(b1Map.get(basket2[i]) != b2Map.get(basket2[i])){
                int totalFruits=fullMap.get(basket2[i]);
                int shouldBe=totalFruits/2;
                int fruitInB1 = b1Map.getOrDefault(basket2[i], 0);
                int fruitInB2 = b2Map.getOrDefault(basket2[i], 0);
                int fruitToEqualize=Math.abs(shouldBe-fruitInB1);
                if(!seen.contains(basket2[i])){
                for(int j=0; j<fruitToEqualize; j++)
                {
                    
                    list.add(basket2[i]);
                }
                 seen.add(basket2[i]);
                }
            }

        }


        Collections.sort(list);
        long ans=0;
        for(int i=0; i<list.size()/2; i++)
        {
            ans=ans+Math.min(list.get(i),2*globalMin);
        }
      
        return ans;

        
    }
}