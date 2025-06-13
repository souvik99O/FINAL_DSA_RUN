class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int arr[]= new int[nums.length];
        Stack<Integer> st= new Stack();

        for(int i=2*nums.length-1; i>=0;i--)
        {
            int index=i%(nums.length);

                    if(!st.empty())
                    {
                            while(!st.empty()&&nums[index]>=st.peek())
                            {
                                st.pop();
                            }
                    }

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
            st.push(nums[index]);
        }
        

        return arr;
        
    }
}