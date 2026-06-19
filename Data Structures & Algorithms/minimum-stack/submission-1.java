class MinStack {
    private Deque<Long> q;
    long mini;

    public MinStack() {
        q=new LinkedList<>();
        mini=0;
    }
    
    public void push(int val) {
        if(q.size()==0){
            q.addLast((long)val);
            mini=val;
        }else{
            if(val>=mini){
                q.addLast((long)val);
            }else{
                q.addLast((long)2*val-mini);
                mini=val;
            }
        }
    }
    
    public void pop() {
        if(q.peekLast()>=mini){
            q.removeLast();
            return ;
        }else{
            mini=2*mini-q.peekLast();
            q.removeLast();
            return ;
        }
    }
    
    public int top() {
        if(q.peekLast()>=mini){
            return Integer.valueOf(String.valueOf(q.peekLast()));
        }else{
            return (int)mini;
        }
    }
    
    public int getMin() {
        return (int)mini;
    }
}
