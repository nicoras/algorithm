package LeetCode673;

public class Solution {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        //以nums[n]结尾的长度
        int[] f = new int[n];
        //以nums[n]结尾的子序列数
        int[] cnt = new int[n];
        //最长子序列长度
        int maxLen = 1;
        int ans = 1;//最少有一个结果
        for(int i=0;i<n;i++) {
            f[i] = 1;
            cnt[i] = 1;
        }
        //j<i i从1->n-1遍历
        for(int i=1;i<n;i++){
            //求i结尾的子序列
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(f[j]+1>f[i]){
                        f[i] = f[j]+1;
                        cnt[i] = cnt[j];
                    }else if(f[i]==f[j]+1){
                        cnt[i] += cnt[j];
                    }
                }
            }
            //出现新的最长子序列，重置ans，否则将当前的序列数累加
            if(f[i]>maxLen){
                maxLen = f[i];
                ans = cnt[i];
            }else if(f[i]==maxLen){
                ans += cnt[i];
            }
        }
        return ans;
    }

}
