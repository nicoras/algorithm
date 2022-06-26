package LeetCode239;

import javafx.util.Pair;

import java.util.PriorityQueue;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair<Integer,Integer>> q = new PriorityQueue<>(nums.length,(o1,o2)->o2.getKey()-o1.getKey());
        int[] ans = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            q.add(new Pair(nums[i],i));
            if(i>=k-1){
                //删除堆顶出窗口的数据，延迟删除
                while(q.peek().getValue()<=i-k){
                    q.poll();
                }
                ans[i-k+1] = q.peek().getKey();
            }
        }
        return ans;
    }

}
