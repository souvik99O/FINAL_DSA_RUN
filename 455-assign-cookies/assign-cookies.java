class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;//cookies
        int count=0;
        while(i<g.length && j<s.length)
        {
            if(g[i]<=s[j])
            {
                count++;
                i++;
                j++;
            }
            else
            {
                while(j<s.length && g[i]>s[j])
                {
                j++; 
                }
            }


        }
        return count;

        
    }
}