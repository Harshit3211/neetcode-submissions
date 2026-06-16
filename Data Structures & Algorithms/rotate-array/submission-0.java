class Solution {
    public void rotate(int[] nums, int k) {
        
        int n=nums.length;
        k%=n;
        swap(nums,0,n-k-1);
        swap(nums,n-k,n-1);
        swap(nums,0,n-1);
    }

    public void swap(int[] nums,int l,int r){
        while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
}
// [6,5,4,3,2,1,8,7]
// [7,8,1,2,3,4,5,6]