class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            return a[1]-b[1];
        }
        );
        for(int i: arr){
            pq.add(new int[]{Math.abs(i-x),i});
        }
        List<Integer> ans=new ArrayList<>();
        while(k!=0){
            ans.add(pq.remove()[1]);
            k--;
        }
        Collections.sort(ans);
        return ans;
    }
}