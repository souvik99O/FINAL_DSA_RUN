class Solution {
    public String[] divideString(String s, int k, char fill) {
        int totalGroups=s.length()/k;
        int leftCharacters=s.length()%k;
        ArrayList <String> arr= new ArrayList<>();

        int l=0;
        int r=k-1;
        
        while(r<s.length())
        {
           arr.add(s.substring(l,r+1));
           l=l+k;
           r=r+k;
           
        }
       if(leftCharacters>0)
       {
        String extra=s.substring(l);
        String sx=fill+"";
        for(int m=0; m<(k-leftCharacters)-1;m++)
        {
          sx=sx+fill ;
        }
        extra=extra+sx;
        arr.add(extra);

       }
       
       
      return arr.toArray(new String[0]);  
    }
}