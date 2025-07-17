class Solution {
    public boolean isMatch(String s, String p) {
        char[] pt = p.toCharArray();
        char[] st = s.toCharArray();
        HashMap<String,Boolean> dp= new HashMap<>();
        boolean ans = solve(0, 0, pt, st,dp);
        return ans;
    }

    public boolean solve(int i, int j, char[] pt, char[] st,HashMap<String,Boolean> dp) {
        int n = st.length;
        int m = pt.length;
        String key=i + "," + j;


        if (i >= n && j >= m) {dp.put(key,true);return true;}
        if (j >= m && i<n){dp.put(key,false); return false;}

        if (i >= n && j<m) {
            for (int k = j; k < m; k++) {
                if (pt[k] != '*'){dp.put(key,false); return false;}
            }
            dp.put(key,true);
            return true;
        }
       
        if(dp.containsKey(key))
        return dp.get(key);

        boolean option1 = false;
        boolean option2 = false;
        boolean match = false;

        if (st[i] == pt[j] || pt[j] == '?') {
            match = solve(i + 1, j + 1, pt, st,dp);
        } else if (pt[j] == '*') {
            option1 = solve(i + 1, j, pt, st,dp);
            option2 = solve(i, j + 1, pt, st,dp);
        } else {
            dp.put(key,false);
            return false;
        }
        if (match == true || option1 == true || option2 == true)
        {  dp.put(key,true);
            return true;
        }
        dp.put(key,false);
        return false;

    }
    // public boolean isMatch(String s, String p) {
    //    char[] pt=p.toCharArray();
    //    char[] st=s.toCharArray();

    //    int i=0;
    //    int j=0;

    //    if(st.length==0 && pt[0]=='*')
    //    return true;

    //    while(j<pt.length &&  i<st.length)
    //    {
    //     if(st[i]==pt[j])
    //     {
    //         i++;
    //         j++;
    //     }
    //     else if(st[i]!=pt[j]  && pt[j]=='?')
    //     {
    //         i++;
    //         j++;
    //     }
    //     else if(st[i]!=pt[j] && pt[j]=='*')
    //     {
    //         if(j==0)
    //         {
    //           return true;  
    //         }
    //         if(j==pt.length-1)
    //         {
    //             return true;
    //         }

    //         if(j+1<pt.length-1){
    //         while(i<st.length && st[i]!=pt[j+1])
    //         {
    //             i++;
    //         }
    //         j++;
    //         }
    //     }
    //     else
    //     {
    //         return false;
    //     }
    //    }
    //    if(j>=pt.length && i>=st.length)
    //    return true;
    //    return false;

    // }
}