class Solution {
    final int MOD= 1_000_000_007;
    public int numberOfWays(int n, int x) {

        int arr[]=findXthPowerArray(n,x);
        int dp[][]=new int[arr.length+1][n+1];   /////////////////////////////////
        for(int i=0; i<dp.length; i++)
        {
            for(int j=0; j<dp[0].length; j++)
            {
                dp[i][j]=-1;
            }
        }

        System.out.println(Arrays.toString(arr));
        int ans= solve(0,0,arr,n,dp);
       
        return ans;
        
    }
    public int [] findXthPowerArray(int n, int x)
    {
        List<Integer> arr= new ArrayList<>();
        for(int i=1; Math.pow(i,x)<=n; i++)
        {
            arr.add((int)Math.pow(i,x));
        }

        int arr1 []= new int[arr.size()];
        for(int i=0; i<arr.size(); i++)
        {
            arr1[i]=arr.get(i);
        }

        return arr1;
    }

    public int solve(int i,int sum ,int [] arr, int n, int dp[][])
    {
        int N= arr.length;

        if(sum>n)
        return 0;

        if(i>=N)
        {
          if(sum==n)
          {
            return 1;
          }  
          return 0;
        }

        if(dp[i][sum]!=-1)
        return dp[i][sum];

        int pick=0;

        if(sum+arr[i]<=n)
        pick=solve(i+1,sum+arr[i],arr,n,dp);

        int notPick=solve(i+1,sum,arr,n,dp);


        return dp[i][sum]=(pick+notPick)%MOD;
    }
}