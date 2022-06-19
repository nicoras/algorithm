package LeetCode47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new int[nums.length];
        chosen = new ArrayList<>(nums.length);
        ans = new ArrayList<>();
        Arrays.sort(nums);
        recurse(nums,0);
        return ans;
    }

    private void recurse(int[]nums,int index){
        if(index==nums.length){
            ans.add(new ArrayList(chosen));
            return;
        }
        System.out.println("index:"+index+"_used:"+Arrays.toString(used)+"_chose:"+chosen.toString());
        for(int i=0;i<nums.length;i++){
             if(used[i]==1||i>0&&nums[i]==nums[i-1]&&used[i-1]==0){
                 continue;
             }
            if(used[i]!=1){
                used[i]=1;
                chosen.add(nums[i]);
                System.out.println("index:"+index+"_used:"+Arrays.toString(used)+"_chose:"+chosen.toString());
                recurse(nums,index+1);
                used[i]=0;
                chosen.remove(index);
                System.out.println("index:"+index+"_used:"+Arrays.toString(used)+"_chose:"+chosen.toString());
            }
        }
    }
    //mark whether index i is used for permutation
    int[] used;
    private List<Integer> chosen;
    private List<List<Integer>> ans;

    public static void main(String[] args) {
        Solution s = new Solution();
        s.permuteUnique(new int[]{3,3,0,3});
    }
}
