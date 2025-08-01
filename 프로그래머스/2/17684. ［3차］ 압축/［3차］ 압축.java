import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer=new LinkedList<>();
        Map<String,Integer> dictionary= new HashMap<>();
        for(int i=0;i<26;i++){
            dictionary.put(String.valueOf((char)('A'+i)),i+1);
        }
        
        int idx=0;
        int len=msg.length();
        int size=26;
        
        while(idx<len){
            int cnt=0;
            for(int i=0;i<len-idx;i++){
                
                String cur = msg.substring(idx,idx+i+1);
                if(dictionary.containsKey(cur)){
                    cnt++;
                    continue;
                }
                else{
                    String pre= msg.substring(idx,idx+i);
                    answer.add(dictionary.get(pre));
                    size++;
                    dictionary.put(cur,size);
                    break;
                }
            }
            idx+=cnt;
            if(idx==len){
                String temp=msg.substring(idx-cnt,len);
                answer.add(dictionary.get(temp));
            }
        }
        return answer;
    }
}