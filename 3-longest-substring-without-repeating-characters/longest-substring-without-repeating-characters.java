class Solution {


    //  public boolean noRepeats(int l, int r, char[] str) {
    //     HashMap<Character, Integer> map = new HashMap<>();

    //     for (int i = l; i <= r; i++) {
    //         char c = str[i];
    //         if (map.containsKey(c)) {
    //             return false;  // Duplicate found
    //         }
    //         map.put(c, 1);
    //     }

    //     return true;  // All characters are unique
    // }


    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char str[]=s.toCharArray();
        int size=str.length;
        int l=0; int r=0; int maxlen=0;int len=0;
        while(r<size)
        {
            map.put(str[r],map.getOrDefault(str[r],0)+1);
            while(map.get(str[r])>1){
                map.put(str[l],map.get(str[l])-1);
                l++;
                
             }

            if(map.get(str[r])==1)
            {
                len=r-l+1;
                if(len>maxlen)
                {
                    maxlen=len;
                }
            }
            
            r++;
        }
        return maxlen;
        
    }
}