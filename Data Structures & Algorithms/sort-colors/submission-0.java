class Solution {
    public void sortColors(int[] nums) {
        int mid1=0;
        int mid2=0;
        int high=nums.length-1;
        while(mid2<=high){
            if(nums[mid2]==0){
                int temp=nums[mid1];
                nums[mid1]=nums[mid2];
                nums[mid2]=temp;
                mid1++;
                mid2++;
            }
            else if(nums[mid2]==1){
                mid2++;
            }else{
                int temp=nums[high];
                nums[high]=nums[mid2];
                nums[mid2]=temp;
                high--;
            }
        }
    }
}