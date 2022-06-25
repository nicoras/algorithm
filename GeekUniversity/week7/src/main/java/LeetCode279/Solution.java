package LeetCode279;


public class Solution {

    /**
     * 等价于lc332零钱兑换
     */
    public int numSquares(int n) {
        int INF = (int)1e9;
        int[] opt = new int[n + 1];
        opt[0] = 0;
        for (int i = 1; i <= n; i++) {
            opt[i] = INF;
            for (int j = 0; j*j <=i; j++)
                opt[i] = Math.min(opt[i], opt[i - j*j] + 1);
        }
        return opt[n];
    }

}
