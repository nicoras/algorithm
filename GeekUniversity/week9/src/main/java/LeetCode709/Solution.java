package LeetCode709;

public class Solution {

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            if(a>='A' && a<='Z'){
                a = (char)(a-'A'+'a');
            }
            sb.append(a);
        }
        return sb.toString();
    }
}
