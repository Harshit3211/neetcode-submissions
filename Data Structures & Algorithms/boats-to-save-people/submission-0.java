class Solution {
    public int numRescueBoats(int[] p, int limit) {
        Arrays.sort(p);
        int l=0;int r=p.length-1;
        int cnt=0;
        while(l<=r){
            if(l==r) {
                cnt++;
                break;
            }
            int sum=p[l]+p[r];
            if(sum>limit){
                cnt++;
                r--;
            }else{
                cnt++;
                l++;
                r--;
            }
        }
        return cnt;

    }
}
