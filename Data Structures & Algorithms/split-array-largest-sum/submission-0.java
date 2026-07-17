class Solution {

    public int calc(int lim,int[] nums){
        int curr=0,part=0;
        for(int i: nums){
            if(curr+i<=lim){
                curr+=i;
            }else{
                part++;
                curr=i;
            }
        }
        if(curr!=0) part++;
        return part;
    }
   
    public int splitArray(int[] nums, int k) {
      int max=0,sum=0;
      for(int i: nums){
        sum+=i;
        max=Math.max(max,i);
      }
      int l=max;
      int r=sum;
      int ans=-1;
      while(l<=r){
        int mid=l+(r-l)/2;
        if(calc(mid,nums)<=k){
            ans=mid;
            r=mid-1;    
        }else{
            l=mid+1;
        }
      }
      return ans;
    }
}