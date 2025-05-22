class Solution {
    public int maxSubArray(int[] nums) {

//O(n2)-------------------------------approach------------------------------------
// int sum=0;
// int max=Integer.MIN_VALUE;
//         for(int i=0; i<nums.length;i++)
//         {
//             sum=0;
//             for(int j=i; j<nums.length; j++)
//             {
//                  sum=sum+nums[j];
//                 if(sum>max)
//                 max=sum;
//             }
//         }

//         return max;
//O(n2)-------------------------------approach------------------------------------


// kedanes algorithm//------------------------------------------------------------

int sum=0;
int max=Integer.MIN_VALUE;
if(nums.length==1)
return nums[0];


//actual kedane but it will not handle all negative cases--------------------------------------------
for(int i=0; i<nums.length;i++)
{
    sum+=nums[i];
    if(sum<0)
    sum=0;

    if(sum>max)
    max=sum;

}
//actual kedane but it will not handle all negative cases--------------------------------------------

if(max==0)
{
    max=Integer.MIN_VALUE;
    for(int i=0; i<nums.length;i++)
    {
        if(nums[i]>max)
        max=nums[i];
    }
}




return max;





// kedanes algorithm//------------------------------------------------------------
        
    }
}