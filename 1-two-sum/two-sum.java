class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int i=0;
        int j=0;
        int flag=0;
        
        for( i=0; i<nums.length;i++)
        {
            for( j=0; j<nums.length;j++){
                if(i==j)
                continue;
                        if(nums[i]+nums[j]==target)
                        {
                            flag=1;
                            break;
                        }
            }

            if(flag==1)
            {
                break;
            }
        }

            int newarr[]={i,j};
            
            return newarr;
    }
}