class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length; i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
          PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );
        int size=0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            if(size<k){
            pq.offer(entry);
            
            }
            else
            {
                if(pq.peek().getValue()<entry.getValue())
                {
                    pq.poll();
                    pq.offer(entry);
                }
            }
            size++;

        }
        int ans[]=new int[k];
        int m=0;
        while(!pq.isEmpty())
        {
           ans[m++]= pq.poll().getKey();
        }

        return ans;
    }
}