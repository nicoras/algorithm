package LeetCode811_subdomainVisitCount;

import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        //出参，最大值
        List<String> rtn = new ArrayList<>(cpdomains.length*3);

        char dot = '.';
        char blank = ' ';
        HashMap<String,Integer> domainCounts = new HashMap<>();
        for(int i=0,len=cpdomains.length;i<len;i++){
            //分解cpdomains
            //找到第一个空格
            String cpdomain = cpdomains[i];
            int idxBlank = cpdomain.indexOf(blank);
            int rep=Integer.valueOf(cpdomain.substring(0,idxBlank));
            int idxDot = idxBlank;
            //循环解析后面的域名，进行计数
            while(idxDot!=-1){
                String domain = cpdomain.substring(idxDot+1);
                Integer domainCount = domainCounts.getOrDefault(domain, 0);
                domainCounts.put(domain,domainCount+rep);
                idxDot = cpdomain.indexOf(dot,idxDot+1);
            }
        }
        //输出至rtn
        for(Map.Entry<String,Integer> entry:domainCounts.entrySet()){
            rtn.add(new StringBuilder().append(entry.getValue()).append(blank).append(entry.getKey()).toString());
        }
        //返回出参
        return rtn;

    }
}