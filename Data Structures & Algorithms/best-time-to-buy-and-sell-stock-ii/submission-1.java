class Solution {
    // public int recur(int ind,int lst,int[] prices,int[][] dp){
    //     if(ind==prices.length) return 0;
    //     if(dp[ind][lst]!=-1) return dp[ind][lst];
        
    //     return ans;
    // }
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length+1][2];
        for(int ind=0;ind<dp.length;ind++) Arrays.fill(dp[ind],0);
        for(int ind=prices.length-1;ind>=0;ind--){
            for(int j=0;j<=1;j++){
                int ans=0;
                if(j==0){
                    ans=Math.max(ans,dp[ind+1][1]-prices[ind]);
                    ans=Math.max(ans,dp[ind+1][0]);
                }
                if(j!=0){
                    ans=Math.max(ans,prices[ind]+dp[ind+1][0]);
                    ans=Math.max(ans,dp[ind+1][1]);
                }
                dp[ind][j]=ans;
            }
        }
        return dp[0][0];
    }
}