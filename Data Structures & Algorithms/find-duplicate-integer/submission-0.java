class Solution {
    public int findDuplicate(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int num=Math.abs(nums[i]);
            int idx=num;
            if(nums[idx]>0){
                nums[idx]*=-1;
            }else{
                return idx;
            }
        }
        return -1;
    }
}
