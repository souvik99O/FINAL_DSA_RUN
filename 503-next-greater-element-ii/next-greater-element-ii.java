class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int arr[]= new int[nums.length];
        Stack<Integer> st= new Stack();

        // Traverse twice to handle circular array - go from right to left
        for(int i=2*nums.length-1; i>=0;i--)
        {
            // Map back to original array using modulo
            int index=i%(nums.length);

            // Pop smaller elements from stack - they can't be next greater
            if(!st.empty())
            {
                while(!st.empty()&&nums[index]>=st.peek())
                {
                    st.pop();
                }
            }

            // Store result only for first pass through array
            if(st.empty() && i<nums.length)
            {
             arr[i]=-1;   
            }
            else
            {
                if(i<nums.length)
                {
                    arr[i]=st.peek();
                }
            }
            
            // Push current element to maintain decreasing stack
            st.push(nums[index]);
        }
        

        return arr;
        
    }
}

// i=5, index=2, nums[2]=1: stack=[] → arr[2] not set, stack=[1]
// i=4, index=1, nums[1]=2: stack=[1] → pop 1, arr[1] not set, stack=[2]  
// i=3, index=0, nums[0]=1: stack=[2] → arr[0] not set, stack=[2,1]
// i=2, index=2, nums[2]=1: stack=[2,1] → arr[2]=2, stack=[2,1,1]
// i=1, index=1, nums[1]=2: stack=[2,1,1] → pop 1,1, arr[1]=-1, stack=[2,2]
// i=0, index=0, nums[0]=1: stack=[2,2] → arr[0]=2, stack=[2,2,1]
