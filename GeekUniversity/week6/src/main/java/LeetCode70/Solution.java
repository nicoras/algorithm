package LeetCode70;

public class Solution {
    public int climbStairs(int n) {

        //f(n)=f(n-1)+f(n-2)
        //f(1)=1 f(2)=2
        if(n==1||n==2){
            return n;
        }
        int fn1=1,fn2=2;
        int fi = 0;
        for(int i=3;i<=n;i++){
            fi=fn1+fn2;
            fn1=fn2;
            fn2=fi;
        }
        return fi;
    }
}
