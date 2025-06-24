class Solution {
    public int lengthOfLongestSubstring(String s) {

        int l=0;int r=0;
        int n=s.length();
        char str[]=s.toCharArray();
        int max=0;
        HashMap<Character,Integer> map = new HashMap<>();

        while(r<n)
        {
            while(map.containsKey(str[r]))
            {
                map.remove(str[l]);
                l++;
            }

            map.put(str[r],r);
            max= Math.max(max,r-l+1);
            r++;

        }

        return max;
    }
}