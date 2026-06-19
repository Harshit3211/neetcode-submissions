class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans=new int[temperatures.length];
        Arrays.fill(ans,-1);
        Deque<Integer> q=new LinkedList<>();
        for(int i=0;i<temperatures.length;i++){
            if(q.size()==0){
                q.addLast(i);
            }else{
                while(q.size()!=0 && temperatures[q.peekLast()]<temperatures[i]){
                    ans[q.peekLast()]=i-q.peekLast();
                    q.removeLast();
                }
                q.addLast(i);
            }
        }
        for(int i=0;i<temperatures.length;i++){
            if(ans[i]==-1) ans[i]=0;
        }
        return ans;
    }
}
