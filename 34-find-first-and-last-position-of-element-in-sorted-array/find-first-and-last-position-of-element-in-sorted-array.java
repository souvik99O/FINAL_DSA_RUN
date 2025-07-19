class Solution {
    public int[] searchRange(int[] arr, int target) {
        
        int low=0;
        int high=arr.length-1;
        int ans[]= new int[2];
        ans[0]=-1;ans[1]=-1; 
        if(arr.length==0)
        {return ans;}
       
       for(int i=0; i<arr.length;i++)
       {
        if(arr[i]==target)
        {
            ans[0]=i;
            while(i<arr.length && arr[i]==target)
            {
                i++;
            }
            ans[1]=i-1;
        }
       }

       return ans;
    }
}