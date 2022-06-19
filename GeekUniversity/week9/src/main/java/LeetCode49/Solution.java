package LeetCode49;

import java.util.*;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> map = new HashMap(strs.length);
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> existStrList = map.getOrDefault(key,new ArrayList<String>());
            existStrList.add(str);
            map.put(key,existStrList);
        }
        return new ArrayList(map.values());
    }
}
