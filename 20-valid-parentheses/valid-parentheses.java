class Solution {
    public boolean isValid(String s) {
        if(s.length()==1||s.length()==0||s.charAt(0)==')'||s.charAt(0)=='}'||s.charAt(0)==']')
        return false;
        char arr[] = s.toCharArray();
        Stack<Character> st  =new Stack<>();
        

        for(int i=0; i<arr.length;i++)
        {
            if(arr[i]=='('||arr[i]=='{'||arr[i]=='[')
            {
                st.push(arr[i]);
            }
            else if (arr[i]==')' && !st.empty() && st.peek()=='(')
            {
                st.pop();
            }
            else if(arr[i]=='}' &&  !st.empty() && st.peek()=='{')
            {
                st.pop();
            }
            else if(arr[i]==']' && !st.empty() && st.peek()=='[')
            {
                st.pop();
            }
            else
            {
                return false;
            }
        }
       
        if(st.empty())
        return true;
        else
        return false;


        
    }
}