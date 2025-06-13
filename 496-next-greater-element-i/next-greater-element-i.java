class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map= new HashMap<>();
        Stack<Integer> st= new Stack();
        int arr[]=new int[nums2.length];
        List<Integer> anslist = new ArrayList();

        for(int i=nums2.length-1;i>=0;i--)
        {
          
            if(!st.empty())
            {
                while(!st.empty() && nums2[i]>st.peek())
                {
                    st.pop();
                }
            }

            if(st.empty())
            {
                arr[i]=-1;
            }
            else
            {
                arr[i]=st.peek();
            }
          st.push(nums2[i]);
          map.put(nums2[i],i);
        }

        for(int i=0; i<nums1.length;i++)
        {
            if(map.containsKey(nums1[i]))
            {
                int indx=map.get(nums1[i]);
                anslist.add(arr[indx]);
            }
            
        }
       int[] ans = new int[anslist.size()];
        for(int i = 0; i < anslist.size(); i++) {
            ans[i] = anslist.get(i);
        }
        return ans;




    }
}