class Solution {
    public int calc(int lim,int[] w){
        int days=0;
        int curr=0;
        for(int i: w){
            if(curr+i<=lim){
                curr+=i;
            }else{
                curr=i;
                days++;
            }
        }
        if(curr!=0) days++;
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int l = 0, h = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            h += w;
        }
        int ans=2*h;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(calc(mid,weights)<=days){
                ans=Math.min(ans,mid);
                h=mid-1;
            }else{
               l=mid+1;
            }
        }
        return ans;
    }
}