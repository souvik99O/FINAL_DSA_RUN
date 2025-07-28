class KthLargest {
   int size=0;
    int k=0;
    PriorityQueue<Integer> pq= new PriorityQueue<>(); 
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int i=0; i<nums.length;i++)
        {
            this.size=nums.length;
            if(i<k)
            {
                pq.offer(nums[i]);
            }
            else
            {
                if(nums[i]>pq.peek())
                {
                    pq.poll();
                    pq.offer(nums[i]);
                }

            }

        }   
    }
    
    public int add(int val) {
        
        if(size<k)
        {
             pq.offer(val);
             size++;
        }
        else
            {
                if(val>pq.peek())
                {
                    pq.poll();
                    pq.offer(val
                    );
                    size++;
                }

            }


            return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */