class Solution {
    public String largestGoodInteger(String num) {
        char ch[]=num.toCharArray();
        int maxAns=Integer.MIN_VALUE;
        int l=0;
        int r=0;
        int windowSize=2;
        String Zero= "000" ;
        int zeroFlag=0;
        HashMap<Character,Integer> map = new HashMap<>();
        //find a window of len 3 and prepare a freq map
        while(windowSize>=0){
            map.put(ch[r],map.getOrDefault(ch[r],0)+1);
            r++;
            windowSize--;
        }
        r--;

        while(r<num.length())
        {
           
            if(map.size()==1 && map.get(ch[r])==3)
            {
                String numm=""+ch[l]+ch[l+1]+ch[r];
                int n=Integer.parseInt(numm);
                maxAns=Math.max(maxAns,n);
            }
            
            map.put(ch[l],map.getOrDefault(ch[l],0)-1);
            if(map.get(ch[l])==0)
            map.remove(ch[l]);
            l++;
            r++;
            

            if(r<num.length())
            map.put(ch[r],map.getOrDefault(ch[r],0)+1);
            
            

        }

        if(maxAns==0) return  Zero ; 
        else if(maxAns==Integer.MIN_VALUE)
        return "";
        else 
        return maxAns+"";


        
    }
}