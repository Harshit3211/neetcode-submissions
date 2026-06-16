class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0){
                nums[i]=3*nums.length;
            }
        }
        for(int i=0;i<nums.length;i++){
            int num=Math.abs(nums[i]);
            int ind=num-1;
            if(ind<0 || ind>=nums.length) continue;
            if(nums[ind]>0) nums[ind]*=-1;
        }
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]>0) return i;
        }
        return nums.length+1;
    }
}