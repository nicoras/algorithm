package LeetCode560;

import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        // 前缀字段和 sum(l,r) = s[r]-s[l-1]
        // pre[i]=pre[i-1]+nums[i]
        // pre[i]-pre[j-1] = k
        // pre[i]-k = pre[j-1] 如果存在 pre[j-1],则pre[i]中存在一个子数组
        int count = 0;
        int pre = 0;
        //前缀和a出现了n次,单个数字也算一次，计数需要加上自己本身
        HashMap<Integer,Integer> map = new HashMap();
        map.put(0,1);//pre[0]=0,0出现了1次
        for(int i=1;i<=nums.length;i++){
            pre += nums[i-1];
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }

        return count;

    }
}
