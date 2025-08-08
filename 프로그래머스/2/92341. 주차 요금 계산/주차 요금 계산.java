import java.util.*;
class Solution {
    public List<Integer> solution(int[] fees, String[] records) {
        Map<String,String> history=new HashMap<>();
        Map<String,Integer> total=new TreeMap<>();
        
        int len=records.length;
        List<Integer> answer=new LinkedList<>();
        for(int i=0;i<len;i++){
            String[] cur=records[i].split(" ");
            String time=cur[0];
            String number=cur[1];
            String type=cur[2];
            if(type.equals("IN")){
                history.put(number,time);
            }
            else{
                String inTime = history.get(number);
                add(total,number,inTime,time);
                history.remove(number);
            }
        }
        for(Map.Entry<String,String> entry:history.entrySet()){
            String number=entry.getKey();
            String inTime=entry.getValue();
            String outTime="23:59";
            add(total,number,inTime,outTime);
        }
        
        for(Map.Entry<String,Integer> entry:total.entrySet()){
            String number=entry.getKey();
            Integer time=entry.getValue();
            if(time<=fees[0]){
                answer.add(fees[1]);
            }
            else{
                int money=fees[1]+ ((time-fees[0]+fees[2]-1)/fees[2])*fees[3];
                answer.add(money);
            }
        }
        
        return answer;
        
    }
    public void add(Map<String,Integer> map,String number,String inTime, String outTime){
        String []in=inTime.split(":");
        String []out=outTime.split(":");
        int minute=Integer.parseInt(out[0])*60+Integer.parseInt(out[1]) - Integer.parseInt(in[0])*60-Integer.parseInt(in[1]);
        
        if(map.containsKey(number)){
            map.put(number,map.get(number)+minute);
        }
        else map.put(number,minute);
    }
}