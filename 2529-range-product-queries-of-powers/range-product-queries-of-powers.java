class Solution {
    public int[] productQueries(int n, int[][] queries) {
         final int MOD = 1_000_000_007;

        List<Integer> powers= new ArrayList<>();

        for(int i=0; i<32; i++)
        {
            int powOf2=1<<i;
            int temp=n & powOf2;
            if( temp!=0 )
            {
                powers.add(powOf2);
            }
        }

        Collections.sort(powers);

        int arr[]= new int[powers.size()];
        for(int i=0; i<powers.size(); i++)
        {
            arr[i]=powers.get(i);
        }


        int ans[]=new int[queries.length];
        long prod=1;
        for(int i=0; i<queries.length; i++)
        {
            for(int j=queries[i][0]; j<=queries[i][1];j++)
            {
                prod = (prod*arr[j]) % MOD;
            }
            ans[i]=(int)prod;
            prod=1;
        }


        return ans;
    }
}