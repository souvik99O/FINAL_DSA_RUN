class Solution {
    public int maximum69Number (int num) {
        int k=0;
        int numCopy=num;
        int len=0;
         
        while(numCopy!=0){
            int ld=num%10;
            // nums[k++]=ld;
            len++;
            numCopy=numCopy/10;
        }
        int nums[]= new int[len];

        while(num!=0){
            int ld=num%10;
            nums[k++]=ld;
            num=num/10;
        }

        for(int i=0; i<nums.length/2; i++)
        {
            int temp=nums[i];
            nums[i]=nums[len-i-1];
            nums[len-i-1]=temp;
        }

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==6){
            nums[i]=9;
            break;
            }
        }

        int ans=0;
        int fact=1;
        
        for(int i=nums.length-1;i>=0; i--)
        {
            int temp=fact*nums[i];
            fact=fact*10;
            ans=ans+temp;
        }


        return ans;
    }
}