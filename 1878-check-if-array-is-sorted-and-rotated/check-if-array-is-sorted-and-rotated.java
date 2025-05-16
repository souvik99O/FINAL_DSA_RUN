class Solution {
    public boolean check(int[] nums) {
        int dup[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            dup[i]=nums[i];
        }
        Arrays.sort(dup);
        for(int k:dup){
        System.out.print(k+"|");}
        System.out.println();

        for(int i=0; i<nums.length; i++)
        {
            rotate(nums,1);
            for(int k:nums){
             System.out.print(k+"|");
             }
             System.out.println();
            if(Arrays.equals(nums,dup))
            return true;
        }

       return false;
        
    }
    public void rotate(int arr[],int k)
    {
        int n=arr.length;
        k=k%n;
        reverse(0,n-k-1,arr);
        reverse(n-k,n-1,arr);
        reverse(0,n-1,arr);
    }
    public void reverse(int start, int end, int[]arr)
    {
        while(start<end)
        {
            int c= arr[start];
            arr[start]=arr[end];
            arr[end]=c;
            start++;
            end--;
        }
    }

    }
