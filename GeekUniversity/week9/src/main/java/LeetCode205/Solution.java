package LeetCode205;

import java.util.HashMap;

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> sm = new HashMap();
        HashMap<Character,Character> tm = new HashMap();

        int sl = s.length();

        for(int i=0;i<sl;i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            Character sv = sm.get(cs);
            Character tv = tm.get(ct);
            if((sv!=null&&!(sv==ct))||(tv!=null&&!(tv==cs))){
                return false;
            }
            sm.put(cs,ct);
            tm.put(ct,cs);
        }
        return true;
    }
}
