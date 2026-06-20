class FreqStack {
    TreeMap<Integer,LinkedList<Integer>> hm;
     Map<Integer,Integer> f;
    Deque<Integer> q;

    public FreqStack() {
        hm=new TreeMap<>();
        f=new HashMap<>();
        q=new LinkedList<>();
    }
    
    public void push(int val) {
        q.addLast(val);
        int freq=f.getOrDefault(val,0);
        freq++;
        f.put(val,freq);
        hm.putIfAbsent(freq,new LinkedList<>());
        hm.get(freq).addLast(val);
    }
    
    public int pop() {
        int hkey=hm.lastKey();
        int ans=hm.get(hkey).peekLast();

        int val=ans;
        int freq=f.getOrDefault(val,0);
        f.put(val,freq-1);
        hm.get(freq).removeLast();
        if(hm.get(freq).size()==0) hm.remove(freq);
        if(f.get(val)==0) f.remove(val);
        
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */