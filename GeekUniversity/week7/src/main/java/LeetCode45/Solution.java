package LeetCode45;

public class Solution {

    public int jump(int[] nums) {

        //动规dp(n)到达n点需要跳跃的最小步数,需要n*n,中间包含无用计算
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            dp[i] = n;
            for(int j=0;j<i;j++){
                if(j+nums[j]>=i){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[n-1];

    }
}
