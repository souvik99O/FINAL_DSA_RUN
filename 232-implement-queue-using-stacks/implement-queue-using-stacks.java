class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        st1= new Stack();
        st2= new Stack();
        
    }
    
    public void push(int x) {

        while(!st1.empty())
        {
            st2.push(st1.peek());
            st1.pop();
        }
        st1.push(x);
        while(!st2.empty())
        {
            st1.push(st2.peek());
            st2.pop();
        }
    }
    
    public int pop() {
        int ele=st1.peek();
        st1.pop();
        return ele;

        
    }
    
    public int peek() {
       return  st1.peek();

        
    }
    
    public boolean empty() {
        if (st1.empty())
        return true;
        else
        return false;
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */