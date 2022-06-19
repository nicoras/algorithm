package LeetCode438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        return find2(s,p);
    }

    //滑动窗口+不同词频字符个数，先滑动窗口，后比较，比官方逻辑容易理解
    private List<Integer> find2(String s, String p){
        //使用diff记录频次不等的字符个数
        //aaabcabc,abc;
        //diffCount数组记录字符数量的差异，=0两个相等，>0s有p无多n个 <=s无p有少-n个
        //窗口移动，出窗口字符频次-1，入窗口字符频次+1
        List<Integer> rtn = new ArrayList();

        if(s.length()<p.length()){
            return rtn;
        }
        //定义数组，存储同一个字符上不相等的数量
        int[] diffCount = new int[26];
        //初始化第一个窗口个的字符数差
        for(int i=0;i<p.length();i++){
            diffCount[s.charAt(i)-'a']++;
            diffCount[p.charAt(i)-'a']--;
        }
        //异构词字符差计数
        int diff=0;
        for(int i=0;i<diffCount.length;i++){
            if(diffCount[i]!=0){
                diff++;
            }
        }
        //第一个窗口如果diff==0;加入记录
        if(diff==0){
            rtn.add(0);
        }
        int slen = s.length(),plen = p.length();
        for(int i=0;i<slen-plen;i++){
            //左窗口右移
            char out = s.charAt(i);
            diffCount[out-'a']--;
            //移除数量-1，所以==0说明s[i]字符数变得相同
            if(diffCount[out-'a']==0){
                diff--;
            }
            //移除数量-1，所以==-1说明s[i]字符数变得不同
            else if(diffCount[out-'a']==-1){
                diff++;
            }
            //右窗口右移
            char in = s.charAt(i+plen);
            diffCount[in-'a']++;
            //同上原理
            if(diffCount[in-'a']==0){
                diff--;
            }else if(diffCount[in-'a']==1){
                diff++;
            }
            //新窗口的diff==0,新窗口异构
            if(diff==0){
                rtn.add(i+1);
            }
        }
        return rtn;
    }

    //滑动窗口,每次比较词频，先比较后滑动
    private List<Integer> find1(String s, String p){
        List<Integer> rtn = new ArrayList();

        if(s.length()<p.length()){
            return rtn;
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for(int i=0;i<p.length();i++){
            //初始化P的词频
            pCount[p.charAt(i)-'a']++;
            //初始化s第一个窗口的词频
            sCount[s.charAt(i)-'a']++;
        }

        for(int i=0;i<=s.length()-p.length();i++){
            //窗口内词频比较
            if(Arrays.equals(sCount,pCount)) {
                rtn.add(i);
            }
            if(i<s.length()-p.length()){
                //窗口右移，最左侧计数-1，最右侧计数+1
                sCount[s.charAt(i)-'a']--;
                sCount[s.charAt(i+p.length())-'a']++;
            }
        }
        return rtn;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("aaabcabc","abc"));
    }
}
