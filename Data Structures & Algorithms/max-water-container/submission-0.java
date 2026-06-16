class Solution {
    public int maxArea(int[] heights) {
        int l=0,r=heights.length-1;
        int ans=0;
        while(l<r){
            int diff=r-l;
            if(heights[l]<heights[r]){
                ans=Math.max(ans,diff*heights[l]);
                l++;
            }else{
                ans=Math.max(ans,diff*heights[r]);
                r--;
            }
        }
        return ans;
    }
}
