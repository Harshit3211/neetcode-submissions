class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int curr=0;
        int ans=0;
        for(int i: nums){
            curr+=i;
            ans+=hm.getOrDefault(curr-k,0);
            hm.put(curr,hm.getOrDefault(curr,0)+1);
        }
        return ans;
    }
}