package LeetCode300;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        for(int i=0;i<n;i++) {
            f[i] = 1;
        }
        //j<i i从1->n-1遍历
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    f[i] = Math.max(f[i],f[j]+1);
                }
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,f[i]);
        }
        return max;
    }
}
