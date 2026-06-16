class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer> hs=new HashSet<>();
       for(Integer i: nums){
        hs.add(i);
       }
       int cnt=0;
       for(Integer i: hs){
        int num=i;
        int temp=0;
        if(hs.contains(num-1)) continue;
        while(hs.contains(num)){
            num++;
            temp++;
        }
        cnt=Math.max(cnt,temp);
       }
       return cnt;
    }
}
