class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return findMedianSortedArrays(nums2,nums1);
        int len= nums1.length+nums2.length;
        int left=(len+1)/2;
        int l=0,r=nums1.length;
        while (l<=r){
            int mid=l+(r-l)/2;
            int mid2=left-mid;
            int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE,r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
            if(mid<nums1.length){
                r1=nums1[mid];
            }
            if(mid2<nums2.length){
                r2=nums2[mid2];
            }
            if(mid-1>=0){
                l1=nums1[mid-1];
            }
            if(mid2-1>=0){
                l2=nums2[mid2-1];
            }
            if(l1<=r2 && l2<=r1){
                                System.out.println(l1+"    "+l2);
                                                System.out.println(r1+"    "+r2);
                return (len%2==1)?Math.max(l1,l2):(double) (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            } else if (l1>r2) {
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
}
