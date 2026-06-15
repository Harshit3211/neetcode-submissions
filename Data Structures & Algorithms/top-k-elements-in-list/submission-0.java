class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i: nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        List<Integer[]>list=new ArrayList<>();
        for(Integer i: hm.keySet()){
            list.add(new Integer[]{hm.get(i),i});
        }
        Collections.sort(list,(a,b)->b[0]-a[0]);
        int [] ans=new int[k];
        int ind=0;
        for(Integer[] i: list){
            ans[ind++]=i[1];
            if(ind>=k) break;
        }
        return ans;
    }
}
