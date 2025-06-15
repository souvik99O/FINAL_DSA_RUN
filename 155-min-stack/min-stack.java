class MinStack {
    Stack<Integer> st= new Stack();
    LinkedList <Integer> list;
    int top;
    int min;
    public MinStack() {
        min=Integer.MAX_VALUE;
        top=-1;
       list=new LinkedList(); 
    }
    
   public void push(int val) {
    list.add(val);
    if (st.isEmpty()) {
        st.push(val);
        min = val;
    } else {
        if (val < min) min = val;
        st.push(Math.min(val, st.peek()));
    }
}

    
  public void pop() {
        if (!st.isEmpty()) {
            st.pop();
        }
        if (!list.isEmpty()) {
            list.removeLast();
        }
        min = st.isEmpty() ? Integer.MAX_VALUE : st.peek(); // always update min
    }
    
    public int top() {
        int l=list.peekLast();
        return l;
        
    }
    
    public int getMin() {
       
        return min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */