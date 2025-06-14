class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st= new Stack();

        for(int i=0; i<asteroids.length;i++)
        {
           boolean destroyed=false;
           //.............(first/prev value).....(coming/current value)
           //......................+ve........&&....-ve------------------------------then only collision possible
            while(!st.empty() && (st.peek()>0 && asteroids[i]<0))
            {
               if(Math.abs(asteroids[i])>Math.abs(st.peek()))
               st.pop();
               else if(Math.abs(asteroids[i])<Math.abs(st.peek())){
               destroyed=true;
               break;}
               else{
               st.pop();
               destroyed=true;
               break;
               }

            }
            
            if (destroyed==false)
            st.push(asteroids[i]);
            
            //equal case handle//
        }

        List<Integer> list=new ArrayList<>();
        if(st.empty())
        return list.stream().mapToInt(Integer::intValue).toArray();
        
        int j=0;
        while(!st.empty())
        {
            list.add(st.peek());
            st.pop();
            j++;
        }
        Collections.reverse(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
        
    }
}