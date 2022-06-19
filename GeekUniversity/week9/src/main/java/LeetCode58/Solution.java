package LeetCode58;

public class Solution {
    public int lengthOfLastWord(String s) {
        int start=0,end=0;
        boolean word = false;
        int len = 0;
        for(int i=0,l=s.length();i<l;i++){
            char c = s.charAt(i);
            //遇到空格，并且已经有单词，说明单词结束,计算单词长度
            if(c==' '){
                //单词结束，计算单词长度，重置start end 位置
                if(word){
                    word = false;
                    len = end-start+1;
                    start = 0;
                    end = 0;
                }
            }else{
                //!word说明单词未开始，此处为单词开头,记录单词start
                if(!word){
                    start = i;
                    word = true;
                }
                //更新单词end
                end = i;
            }
            //如果有单词起始但是没有结尾，说明最后一个idx是单词结尾
            if(word){
                len = end-start+1;
            }

        }
        return len;

    }
}
