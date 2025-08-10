class Solution {
    public boolean checkValidString(String s) {
        char arr[]= s.toCharArray();
        int min=0;
        int max=0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]=='(')
            {
                min=min+1;
                max=max+1;
            }
            if(arr[i]==')')
            {
                
                min=min-1;
                if(min<0)
                min=0;
                max=max-1;
            }
            if(arr[i]=='*')
            {
                min=min-1;
                if(min<0)
                min=0;
                max=max+1;
            }
            if(max<0)
            return false;
        }
        if(min==0)
        return true;
        else
        return false;
        
    }
}