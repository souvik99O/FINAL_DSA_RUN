class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // int i=0;
        // int j=0;
        // int flag=0;
   //brute force approach-----------------------------------------------     
        // for( i=0; i<nums.length;i++)
        // {
        //     for( j=0; j<nums.length;j++){
        //         if(i==j)
        //         continue;
        //                 if(nums[i]+nums[j]==target)
        //                 {
        //                     flag=1;
        //                     break;
        //                 }
        //     }

        //     if(flag==1)
        //     {
        //         break;
        //     }
        // }

        // int newarr[]={i,j};
            
        //     return newarr;
//brute force approach-----------------------------------------------

//better approach-----------------------------------------------

HashMap <Integer,Integer> map = new HashMap<>();
int newarr[]=new int[2];
int i=0;
//CAN FIRST POPULATE THE MAP AND THEN SEARCH OR TOGETHER(BETTER)
// //populating the hash map to find target-element
// for(i=0; i<nums.length;i++)
// {
//     map.put(nums[i],i);
// }


//POPULATING AND Searching with o(1)

for(i=0; i<nums.length;i++)
{

int findElement= target-nums[i];
if(map.containsKey(findElement))
        {
            newarr[0]=map.get(findElement);
            newarr[1]=i; 
        }
        else
        {
           map.put(nums[i],i); 
        }

}

return newarr;
            
    }
}