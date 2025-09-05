import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int answerTime=0;
        int len=timetable.length;
        Queue<Integer> timeTable= new PriorityQueue<>();
        for(int i=0;i<len;i++){
            String []temp= timetable[i].split(":");
            int hour= Integer.parseInt(temp[0]);
            int minute=Integer.parseInt(temp[1]);
            if(hour==23 && minute==59) continue;
            timeTable.offer(60 *hour + minute);
        }
        
        int time= 540+ t*(n-1);
        
        int cur=540;
        for(int i=0;i<n;i++){
            if(cur!=time){
                for(int j=0;j<m;j++){
                    if(timeTable.isEmpty()) break;
                    if(timeTable.peek()<=cur)
                        timeTable.poll();
                    else
                        break;
                }
                cur +=t;
            }
            else{
                int last=0;
                boolean flag=false;
                for(int j=0;j<m;j++){
                    if(timeTable.isEmpty()){
                        flag=true;
                        break;
                    }
                    if(timeTable.peek()<=cur)
                        last=timeTable.poll();
                    else{
                        flag=true;
                        break;
                    }
                }
                if(flag)
                    answerTime=cur;
                else{
                    answerTime=last-1;
                }
            }
        }
        int hour= answerTime/60;
        int minute=answerTime%60;
        answer=String.format("%02d",hour)+":"+String.format("%02d",minute);
        return answer;
    }
}