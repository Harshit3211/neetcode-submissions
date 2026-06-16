class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pref=new int[nums.length+2];
        int[] suff=new int[nums.length+2];
        Arrays.fill(pref,1);
        Arrays.fill(suff,1);
        for(int i=0;i<nums.length;i++){
            pref[i+1]=pref[i]*nums[i];
        }
        // System.out.println(Arrays.toString(pref));
        for(int i=nums.length-1;i>=0;i--){
            suff[i+1]=suff[i+2]*nums[i];
        }

        // System.out.println(Arrays.toString(suff));

        int[] ans=new int[nums.length];
        for(int i=1;i<=nums.length;i++){
            ans[i-1]=pref[i-1]*suff[i+1];
        }
        return ans;
    }
}  
