import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
class Solution {
    public List<String> solution(String[] record) {
        Map<String,String> nickName =new HashMap<>();
        int len=record.length;
        List<String> answer=new LinkedList<>();
        for(int i=0;i<len;i++){
            String [] cur=record[i].split(" ");
            if(cur[0].equals("Leave")) continue;
            
            nickName.put(cur[1],cur[2]);
        }
        
        for(int i=0;i<len;i++){
            String []cur=record[i].split(" ");
            if(cur[0].equals("Enter")){
                answer.add(nickName.get(cur[1])+"님이 들어왔습니다.");
            }
            else if(cur[0].equals("Leave")){
                answer.add(nickName.get(cur[1])+"님이 나갔습니다.");
            }
            
        }
        return answer;
    }
}