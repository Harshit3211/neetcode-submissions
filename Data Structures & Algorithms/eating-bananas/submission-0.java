class Solution {
       public int calc(int[] piles,int val){
        int ans=0;
        for (int i = 0; i < piles.length; i++) {
            ans+=(piles[i]+val-1)/val;
        }
        return ans;
    }

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int r=piles[piles.length-1];
        int l=1,ans=-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if(calc(piles,mid)<=h){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}
