package LeetCode151;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public String reverseWords(String s) {
        s = s.trim();
        Deque<String> d = new ArrayDeque();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            if(a!=' '){
                sb.append(a);
            }else if(sb.length()>0){
                d.offerFirst(sb.toString());
                sb.setLength(0);
            }
        }
        d.offerFirst(sb.toString());
        return String.join(" ",d);

    }
}
