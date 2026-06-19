class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[]=new int[nums.length-k+1];
        Deque<Integer> q=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(i>=k){
                if(q.size()!=0 && q.peekFirst()<=i-k){
                    q.removeFirst();
                }
            }
            while(q.size()!=0 && nums[q.peekLast()]<nums[i]){
                q.removeLast();
            }
            q.addLast(i);
            if(i>=k-1){
                ans[i-(k-1)]=nums[q.peekFirst()];
            }
        }
        return ans;
    }
}
