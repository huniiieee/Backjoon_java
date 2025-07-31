import java.util.Map;
import java.util.HashMap;
import java.util.Set;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        Map<String,Integer> map1=getPair(str1);
        Map<String,Integer> map2=getPair(str2);
        
        answer=similarity(map1,map2);

        return answer;
    }
    public Map<String,Integer> getPair(String str){
        Map<String,Integer> map=new HashMap<>();
        int len=str.length();
        for(int i=0;i<len-1;i++){
            String sub=str.substring(i,i+2).toUpperCase();
            char front=sub.charAt(0);
            char back=sub.charAt(1);
            if(!Character.isAlphabetic(front)||!Character.isAlphabetic(back)){
                continue;
            }
            
            if(map.containsKey(sub)) map.put(sub,map.get(sub)+1);
            else map.put(sub,1);
        }
        return map;
    }
    
    public int similarity(Map<String,Integer> map1,Map<String,Integer> map2){
        int intersection=0;
        int union=0;
        Set<String> map1Key=map1.keySet();
        Set<String> map2Key=map2.keySet();
        
        for(String s:map1Key){
            if(map2Key.contains(s)){
                intersection +=Integer.min(map1.get(s),map2.get(s));
                union +=Integer.max(map1.get(s),map2.get(s));
            }
            else{
                union +=map1.get(s);
            }
        }
        
        for(String s:map2Key){
            if(!map1Key.contains(s)){
                union +=map2.get(s);
            }
        }
        return union!=0 ?intersection*65536/union : 65536;
    }
}