package LeetCode55;

public class Solution {

    /**
     * 定义f[i] 第i个点可以从之前的点到达
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n];
        f[0]=true;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(f[j] && j+nums[j]>=i){
                    f[i]=true;
                    break;
                }
            }
        }
        return f[n-1];
    }
}
