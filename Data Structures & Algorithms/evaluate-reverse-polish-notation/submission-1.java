class Solution {

   public int compute(String s1,String s2,String s){
        int v1=Integer.valueOf(s1);
        int v2=Integer.valueOf(s2);
        if(s.equals("+")) return v1+v2;
        if(s.equals("-")) return v1-v2;
        if(s.equals("*")) return v1*v2;
        if(s.equals("/")) return v1/v2;
        return 0;
    }
    public int evalRPN(String[] tokens) {
        Deque<String> q=new LinkedList<>();
        for(String s: tokens){
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                String s2=q.removeLast();
                String s1=q.removeLast();
                int val=compute(s1,s2,s);
                q.addLast(String.valueOf(val));
            }else{
                q.addLast(s);
            }
        }
        return Integer.valueOf(q.peekLast());
    }
}
