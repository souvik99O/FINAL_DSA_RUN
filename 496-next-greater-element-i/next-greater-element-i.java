class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map= new HashMap<>();
        Stack<Integer> st= new Stack();
        int arr[]=new int[nums2.length];
        List<Integer> anslist = new ArrayList();

        // Find next greater elements for nums2 using stack
        for(int i=nums2.length-1;i>=0;i--)
        {
            // Pop smaller elements from stack
            if(!st.empty())
            {
                while(!st.empty() && nums2[i]>st.peek())
                {
                    st.pop();
                }
            }

            // Store result and build map
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

        // Find answers for nums1 elements
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

/*
Example trace for nums1=[4,1,2], nums2=[1,3,4,2]:

Building next greater array for nums2:
i=3, nums2[3]=2: stack=[] → arr[3]=-1, stack=[2], map={2→3}
i=2, nums2[2]=4: stack=[2] → pop 2, arr[2]=-1, stack=[4], map={2→3, 4→2}  
i=1, nums2[1]=3: stack=[4] → arr[1]=4, stack=[4,3], map={2→3, 4→2, 3→1}
i=0, nums2[0]=1: stack=[4,3] → arr[0]=3, stack=[4,3,1], map={2→3, 4→2, 3→1, 1→0}

arr = [3, 4, -1, -1]

Finding answers for nums1:
nums1[0]=4: map has 4→2, arr[2]=-1 → anslist=[−1]
nums1[1]=1: map has 1→0, arr[0]=3 → anslist=[−1,3]  
nums1[2]=2: map has 2→3, arr[3]=-1 → anslist=[−1,3,−1]

Result: [-1,3,-1]
*/
