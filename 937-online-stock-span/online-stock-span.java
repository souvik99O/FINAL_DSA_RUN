class pair{
int price;
int index;
    pair(int price,int index)
    {
        this.price=price;
        this.index=index;
    }
}

class StockSpanner {
    int curIndex=0;

    Stack<pair> st;

    public StockSpanner() {
        st= new Stack();    
    }

    
    
    public int next(int price) {
        

        while(!st.empty() && price>=st.peek().price )
        {
            st.pop();
        }
        int ans=0;
        ans=!st.empty()?curIndex-st.peek().index:1;

        if(st.empty())
        {
            ans=curIndex+1;
        }
        
        st.push(new pair(price,curIndex));
        curIndex++;

        return ans;
        
    }
}

