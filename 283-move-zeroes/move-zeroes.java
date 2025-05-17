class Solution {
    public void moveZeroes(int[] nums) {
        // int i=0;
        // int j=i+1;
        // int zeros=0;
        // int n= nums.length;
        
        // for(int m=0; m<nums.length;m++)
        // {
        //     if(nums[m]==0)
        //     {
        //         zeros++;
        //     }
        // }

    // if(zeros>0){
    //     while(i<=(n-zeros))
    //     {
    //         if(nums[i]==0)
    //         {
    //             while(j<nums.length && nums[j]==0 )
    //             {
    //                 j++;
    //             }

    //             if(j<n){
    //             int c= nums[j];
    //             nums[j]= nums[i];
    //             nums[i]=c;
    //             }

    //             i++;
    //             j=i;
    //         }
    //         else
    //         {
    //             i++;
    //             j++;
    //         }
    //     }
    // }


        int i=0;
        int j=i+1;
        int zeros=0;
        int n= nums.length;
        
        for(int m=0; m<nums.length;m++)
        {
            if(nums[m]==0)
            {
                zeros++;
            }
        }
    
    
    while(i<n-zeros)
    {
        if( j<n && nums[i]==0 && nums[j]!=0)
        {
           int c= nums[j];
            nums[j]= nums[i];
            nums[i]=c;

            j++;
            i++;
        }
        else if(j<n && nums[i]==0 && nums[j]==0){
            j++;
        }
        else
        {
            i++;
            j++;
        }
    }

        
    }
}