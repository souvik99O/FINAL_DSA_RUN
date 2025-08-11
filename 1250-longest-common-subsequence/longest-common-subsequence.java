class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char ch1[]=text1.toCharArray();
        char ch2[]=text2.toCharArray();
        int n=ch1.length;
        int m=ch2.length;
        
        int dp[][]=new int[ch1.length+1][ch2.length+1];
        for(int i=0; i<ch1.length+1; i++){
        Arrays.fill(dp[i],-1);
        }
        int ans=solve(n-1,m-1,dp,ch1,ch2);
        return ans;
        
    }

    int solve(int i, int j, int dp[][],char ch1[], char ch2[])
    {
        if(i<0 || j<0)
        return 0;

        if(dp[i][j]!=-1)
        return dp[i][j];
        int op1=0;
        int op2=0;
        int match=0;
        if(ch1[i]==ch2[j])
        {
            match=1+solve(i-1,j-1,dp,ch1,ch2);
        }
        else
        {
            op1=solve(i-1,j,dp,ch1,ch2);
            op2=solve(i,j-1,dp,ch1,ch2);
        }
        int temp=Math.max(op1,op2);

        return dp[i][j]=Math.max(match,temp);
    }
}