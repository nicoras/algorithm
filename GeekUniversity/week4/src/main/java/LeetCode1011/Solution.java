package LeetCode1011;

public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //将问题转化成二分答案，下界max weight,上界 sum weight
        //上下界中一个数能保证在N天运输完成所有的组合在这两个数之间
        //获取二分答案上下界
        int left = 0,right = 0;
        for(int i=0,size=weights.length;i<size;i++){
            right = right+weights[i];
            left = Math.max(left,weights[i]);
        }
        //二分法查询答案
        // System.out.println(left+"_"+right);
        while(left<right){
            int mid = left+(right-left)/2;
            // System.out.println("mid:"+mid);
            if(check(weights,mid,days)){
                right = mid;
            }else{
                left = mid+1;
            }
            // System.out.println("left:"+left+"_right:"+right);
        }
        return right;
    }

    //通过maxWeight分隔weights,判断组合数是否<=days
    private boolean check(int[] weights,int maxWeight,int days){
        int day = 1;
        int sum = 0;
        int i = 0;
        while(i<weights.length){
            sum = sum+weights[i];
            //超重重新开始下个循环
            if(sum>maxWeight){
                day+=1;
                sum=0;
            }else{
                i++;
            }
        }
        // System.out.println("day:"+day);
        return day<=days;
    }
}
