package LeetCode74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int width= matrix[0].length;
        int height = matrix.length;
        int left = 0,right= width*height-1;
        while(left<=right){
            int mid = left+right>>1;
            //mid换算成矩阵下标
            int m = mid/width;
            int n = mid%width;
            if(matrix[m][n]<target){
                left = mid+1;
            }else if(matrix[m][n]>target){
                right = mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
