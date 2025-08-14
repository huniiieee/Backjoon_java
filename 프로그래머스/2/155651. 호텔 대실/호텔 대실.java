import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        List<String> list=new LinkedList<>();
        int len=book_time.length;
        Arrays.sort(book_time , (a,b)->a[0].compareTo(b[0]));
        
        for(int i=0;i<len;i++){
            String curStartTime=book_time[i][0];
            String curEndTime= book_time[i][1];
            Integer curStart=minute(curStartTime);
            Integer curEnd=minute(curEndTime);
            int roomNumber=-1;
            int minDiff=Integer.MAX_VALUE;
            int j=0;
            for(String endTime:list){
                Integer temp=minute(endTime);
                if(curStart>=temp+10){
                    if(minDiff>curStart-temp){
                        minDiff=curStart-temp;
                        roomNumber=j;
                    }
                }
                j++;
            }
            if(roomNumber==-1){
                list.add(curEndTime);
            }
            else{
                list.set(roomNumber,curEndTime);
            }
        }
        return list.size();
    }
    
    public int minute(String time){
        String []temp= time.split(":");
        return 60*(Integer.parseInt(temp[0]))+Integer.parseInt(temp[1]);
    }
}