class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int st=0, end=n*m-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            int nr=mid/m,nc=mid%m;
            if(matrix[nr][nc]==target){
                return true;
            }
            else if(matrix[nr][nc]<target){
                st=mid+1;
            }
            else if(matrix[nr][nc]>target){
                end=mid-1;
            }
        }
        return false;
    }
}
