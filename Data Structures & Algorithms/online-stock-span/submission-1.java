class Pair{
    public int x;
    public int y;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class StockSpanner {
    Deque<Pair>q;

    public StockSpanner() {
        q=new LinkedList<>();
    }
    
    public int next(int price) {
        int ans=1;
        if(q.size()==0 || q.peekLast().x>price){
            q.addLast(new Pair(price,ans));
        }else{
            while(q.size()!=0 && q.peekLast().x<=price){
                ans+=q.peekLast().y;
                q.removeLast();
            }
            q.addLast(new Pair(price,ans));
        }
        return ans;
    }
}
// 100,80,60,70,60,75,85
// 1.  1.  1 2   1 4. 6
// 1.  1. 1. 2   1 4 6

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */