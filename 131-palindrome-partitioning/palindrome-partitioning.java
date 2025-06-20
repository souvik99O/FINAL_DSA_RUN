class Solution {
    
    public List<List<String>> partition(String s) {
        List<List<String>> mainList = new ArrayList<>();
        List<String> pStr = new ArrayList<>();

        f(s,0,pStr,mainList);
        
        return mainList;
    }

    public static void f(String s,int startingIndex,List<String> pStr,List<List<String>> mainList)
    {
        if(startingIndex>=s.length())
        {
            mainList.add(new ArrayList(pStr));
            return;
        }


        for(int i=startingIndex; i<s.length();i++)//i is the ending index
        {
            if(isPalindrome(s,startingIndex,i))
            {
                pStr.add(s.substring(startingIndex,i+1));
                f(s,i+1,pStr,mainList);
                pStr.remove(pStr.size()-1);
            }
        }
    }


    

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}



