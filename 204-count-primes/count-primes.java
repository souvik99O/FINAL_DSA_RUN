class Solution {
    public int countPrimes(int n) {
        n=n-1;
        if(n==-1 || n==0 || n==1)
        return 0;
        
       int arr[]=new int [n+1];

        for(int i=2; i<arr.length;i++)
        {
            arr[i]= 1;
        }

        for(int i=2; i*i<=arr.length;i++)
        {
            if(arr[i]==1)
            {
               for(int j=i*i; j<arr.length;j+=i)
               {
                arr[j]=0;
               }
            }
        }
       int count=0;
        for(int i=0; i<arr.length;i++)
        {
            if(arr[i]==1)
            count++;
        }
        return count;
        
    }
}