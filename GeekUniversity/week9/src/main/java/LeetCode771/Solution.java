package LeetCode771;

import java.util.HashSet;

public class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> jewelTypes = new HashSet(jewels.length());
        for(int i=0;i<jewels.length();i++){
            jewelTypes.add(jewels.charAt(i));
        }
        int count=0;
        for(int i=0;i<stones.length();i++){
            if(jewelTypes.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }
}
