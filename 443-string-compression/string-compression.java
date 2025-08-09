class Solution {
    public int compress(char[] chars) {
        int c=0;
        StringBuilder sb= new StringBuilder();
        int i=0;
        char cur=chars[0];
        for(i=0; i<chars.length; i++)
        {
            
            if(chars[i]==cur)
            c++;
            else
            {
            sb.append(cur);
            if(c>1)
            sb.append(c);
            c=1;
            cur=chars[i];
            }
        }

        sb.append(cur);
        if(c>1)
        sb.append(c);

        
        String s=sb.toString();
        for(int k=0; k<s.length(); k++)
        {
           chars[k]=s.charAt(k);
        }



        return sb.length();
    }
}