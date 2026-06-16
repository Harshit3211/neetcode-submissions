class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n1=0,f1=0;
        int n2=nums[0]+1,f2=0;
        for(int i: nums){
            if(f1==0 && i!=n2){
                f1=1;
                n1=i;
            }else if(f2==0 && i!=n1){
                f2=1;
                n2=i;
            }else if(i==n1){
                f1++;
            }else if(i==n2){
                f2++;
            }else{
                f1--;
                f2--;
            }
        }
        int mini=(nums.length/3)+1;
        int ct1=0,ct2=0;
        for(int i: nums){
            if(i==n1) ct1++;
            if(i==n2) ct2++;
        }
        List<Integer> ans=new ArrayList<>();
        if(ct1>=mini) ans.add(n1);
        if(ct2>=mini) ans.add(n2);
        return ans;
    }
}