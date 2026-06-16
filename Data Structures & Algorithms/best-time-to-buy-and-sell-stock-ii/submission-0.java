class Solution {
    public int recur(int ind,int lst,int[] prices,int[][] dp){
        if(ind==prices.length) return 0;
        if(dp[ind][lst]!=-1) return dp[ind][lst];
        int ans=0;
        if(lst==0){
            ans=Math.max(ans,recur(ind+1,1,prices,dp)-prices[ind]);
            ans=Math.max(ans,recur(ind+1,0,prices,dp));
        }
        if(lst!=0){
            ans=Math.max(ans,prices[ind]+recur(ind+1,0,prices,dp));
            ans=Math.max(ans,recur(ind+1,1,prices,dp));
        }
        dp[ind][lst]=ans;
        return ans;
    }
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        return recur(0,0,prices,dp);
    }
}