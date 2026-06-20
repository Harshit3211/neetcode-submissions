class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> q=new LinkedList<>();
        int ans=0;
        for(int i=0;i<heights.length;i++){
            while(q.size()!=0 && heights[q.peekLast()]>=heights[i]){
                int h=heights[q.peekLast()];
                q.removeLast();
                int ptr1=(q.size()!=0)?q.peekLast()+1:0;
                
                int w=(i-1)-ptr1+1;
                ans=Math.max(ans,h*w);
            }
            q.addLast(i);
        }
        while(q.size()!=0){
            int h=heights[q.peekLast()];
            q.removeLast();
            int ptr1=(q.size()!=0)?q.peekLast()+1:0;
            
            int w=(heights.length-1)-ptr1+1;
            ans=Math.max(ans,h*w);
        }
        return ans;
    }
}
