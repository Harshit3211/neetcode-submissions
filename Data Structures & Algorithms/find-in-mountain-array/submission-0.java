/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length=mountainArr.length();
        int l=1;
        int r=length-2;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int lft=mountainArr.get(mid-1);
            int rgt=mountainArr.get(mid+1);
            int midval=mountainArr.get(mid);
            if(midval==target) return mid;
            if(midval>lft && midval>rgt){
                ans=mid;
                break;
            }
            if(midval<rgt){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        l=0;
        r=ans;
        while(l<=r){
            int mid=l+(r-l)/2;
            int midval=mountainArr.get(mid);

            if(midval==target) return mid;

            if(midval<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }

        l=ans+1;
        r=length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int midval=mountainArr.get(mid);

            if(midval==target) return mid;

            if(midval<target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
       
    }
}