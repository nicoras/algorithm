package LeetCode120;

import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        /**
         * 0 f(0,0)
         * 0,0 f(1,0),f(1,1)
         * 0,0,0 f(2,0),f(2,1),f(2,2)
         * 0,0,0,0
         * f(i,j)表示 (i,j)时的最小路径和
         * f(i,j) = min{f(i-1,j-1),f(i-1,j)}+c(i,j)
         * f(i,0)=f(i-1,0)+c(i,0);
         * f(i,i)=f(i-1,i-1)+c(i,i)
         */
        int n = triangle.size();
        int[][] f = new int[2][n];
        f[0][0] = triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            f[i&1][0] = f[i-1&1][0]+triangle.get(i).get(0);
            for(int j=1;j<i;j++){
                f[i&1][j] = Math.min(f[i-1&1][j-1],f[i-1&1][j])+triangle.get(i).get(j);
            }
            f[i&1][i] = f[i-1&1][i-1]+triangle.get(i).get(i);
        }
        int minx = f[n-1&1][0];
        for(int j=1;j<n;j++){
            minx = Math.min(minx,f[n-1&1][j]);
        }
        return minx;
    }
}
