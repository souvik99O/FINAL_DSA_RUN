//greedy solution---------------------------------------
// class Solution {
   

//     public int rob(int[] nums) {
//         if(nums.length==0)
//         return 0;
//         if (nums.length == 1)
//             return nums[0];

//         int maxCash = Integer.MIN_VALUE;
//         int maxInd = 0;
//         for (int i = 0; i < nums.length; i++) {
           
//             if(nums[i]>maxCash)
//             {
//                 maxCash=nums[i];
//                 maxInd=i;
//             }
//         }

//          // Create left array (elements before maxInd-1)
//         int[] leftArr;
//         if(maxInd >= 2) {
//             leftArr = new int[maxInd - 1];
//             for(int i = 0; i < maxInd - 1; i++) {
//                 leftArr[i] = nums[i];
//             }
//         } else {
//             leftArr = new int[0];
//         }
        
//         // Create right array (elements after maxInd+1)
//         int[] rightArr;
//         if(maxInd + 2 < nums.length) {
//             rightArr = new int[nums.length - (maxInd + 2)];
//             int k = 0;
//             for(int i = maxInd + 2; i < nums.length; i++) {
//                 rightArr[k++] = nums[i];
//             }
//         } else {
//             rightArr = new int[0];
//         }

//         int cur = maxCash;
//         int left = rob(leftArr);
//         int right = rob(rightArr);

//         return left + right + cur;

//     }
// }

//recursive solution-----------------<will give TLE 2^N>-------


// class Solution {
   
//     public int rob(int[] nums) {
//         int sum=0;
//         int maxRob= solve(0,sum,nums);
//         return maxRob;
//     }

//     int solve(int index,int sum,int nums[])
//     {
//         if(index>=nums.length){
//         return sum;
//         }
//         int rob=solve(index+2,sum+nums[index],nums);
//         int notrob=solve(index+1,sum,nums);

//         return Math.max(rob,notrob);
//     }
// }



////----------------------------------------------
//cant memoize the above solution as the function depends on two parametere one is the index and anothere is the  sum, like for same index there will be two values like (1,100,nums) and (1,50,nums) memoizing can over write values of one only----------------------

//below is the memoized solution that wont work;

// class Solution {
   
//     public int rob(int[] nums) {
//         int sum=0;
//         int dp[] = new int [nums.length+1];
//         for(int i=0; i<nums.length+1;i++)
//         {
//             dp[i]=-1;
//         }
//         int maxRob= solve(0,sum,nums,dp);
//         return maxRob;
//     }

//     int solve(int index,int sum,int nums[],int dp[])
//     {
//         if(index>=nums.length){
//         return sum;
//         }
//         if(dp[index]!=-1)
//         return dp[index];
//         int rob=solve(index+2,sum+nums[index],nums,dp);
//         int notrob=solve(index+1,sum,nums,dp);

//         return dp[index]=Math.max(rob,notrob);
//     }
// }

//below remove sum param and memoize---------------------------

class Solution {
   
    public int rob(int[] nums) {
        int dp[] = new int [nums.length+1];
        for(int i=0; i<nums.length+1;i++)
        {
            dp[i]=-1;
        }
        int maxRob= solve(0,nums,dp);
        return maxRob;
    }

    int solve(int index,int nums[],int dp[])
    {
        if(index>=nums.length){
        return 0;
        }
        if(dp[index]!=-1)
        return dp[index];

        int rob=nums[index]+solve(index+2,nums,dp);
        int notrob=solve(index+1,nums,dp);

        return dp[index]=Math.max(rob,notrob);
    }
}
