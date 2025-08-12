import java.util.*;
class Solution {
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer=new LinkedList<>();
        Map<String,Integer> map=new TreeMap<>();
        int len=orders.length;
        for(int i=0;i<len;i++){
            String cur=orders[i];
            String [] curs=cur.split("");
            Arrays.sort(curs);
            StringBuilder sb=new StringBuilder();
            add(curs,curs.length,-1,0,course,map,sb);
        }
        
        int lenCourse=course.length;
        int[] maxCourse=new int[lenCourse];
        
        for(Map.Entry<String,Integer> e:map.entrySet()){
            for(int i=0;i<lenCourse;i++){
                if(e.getKey().length()==course[i])
                    maxCourse[i]=Integer.max(maxCourse[i],e.getValue());
            }
        }
        
        for(Map.Entry<String,Integer> e:map.entrySet()){
            if(e.getValue()<=1) continue;
            for(int i=0;i<lenCourse;i++){
                if(e.getKey().length()==course[i]&&e.getValue()==maxCourse[i])
                    answer.add(e.getKey());
            }
        }
        return answer;
    }
    public void add(String []order,int len,int pre,int cnt,int []course,Map<String,Integer> map,StringBuilder temp){
        if(len<cnt)
            return;
        
        for(int num:course){
            if(num==cnt){
                String tempString=temp.toString();
                if(map.containsKey(tempString)) map.put(tempString,map.get(tempString)+1);
                else map.put(tempString,1);
            }
        }
        
        for(int i=pre+1;i<len;i++){
            temp.append(order[i]);
            add(order,len,i,cnt+1,course,map,temp);
            temp.deleteCharAt(temp.length() - 1);
        }
        
    }
}