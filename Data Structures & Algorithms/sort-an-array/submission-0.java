class Solution {
    public int[] sortArray(int[] nums) {
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        for(int i: nums){
            tm.put(i,tm.getOrDefault(i,0)+1);
        }
        int ptr=0;
        for(int i: tm.keySet()){
            int val=tm.get(i);
            while(val!=0){
                nums[ptr++]=i;
                val--;
            }
        }
        return nums;

    }
}