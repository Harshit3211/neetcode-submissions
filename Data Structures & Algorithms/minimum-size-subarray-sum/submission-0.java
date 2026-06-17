class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans=2*nums.length;
        int l=0,r=0;
        int sum=0;
        while(l!=nums.length){
            while(r<nums.length && sum+nums[r]<target){
                sum+=nums[r];
                r++;
            }
            if(r<nums.length && sum+nums[r]>=target){
                ans=Math.min(ans,r+1-l);
            }
            sum-=nums[l];
            l++;
        }
        if(ans>nums.length) return 0;
        return ans;
        
    }
}