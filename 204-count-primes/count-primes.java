class Solution {
    public int countPrimes(int n) {
//12345678910
        if(n==0 || n==1)
        return 0;
        
        int arr[]=new int [n-2];
        for(int i=0; i<arr.length;i++)
        {
            arr[i]=1;
        }
        for(int i=0; i<arr.length;i++)
        {
            if(arr[i]==1)
            {
                int k=2;
                int ind=0;
                while(ind<n-2)
                {
                    int num=i+2;
                    int multiple=num*k;
                    ind=multiple-2;
                    if(ind<n-2)
                    arr[ind]=0;
                    k++;
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