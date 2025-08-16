class Solution {
    public int totalFruit(int[] fruits) {
        //longest subarray having two distinct elements
        int maxFruits=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int l=0; int r=0;
        while(r<fruits.length)
        {
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            while(map.size()>2)
            {
               map.put(fruits[l],map.getOrDefault(fruits[l],0)-1);
               if(map.get(fruits[l])==0)
               map.remove(fruits[l]); 
               l++;
            }
            maxFruits=Math.max(maxFruits,(r-l+1));
            r++;
        }
        return maxFruits;
        
    }
}