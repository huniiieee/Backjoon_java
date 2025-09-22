import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int len=photo.length;
        
        int[] answer = new int[len];
        
        Map<String,Integer> scores=new HashMap<>();
        for(int i=0;i<name.length;i++){
            scores.put(name[i],yearning[i]);
        }
        
        for(int i=0;i<len;i++){
            int sum=0;
            for(String s:photo[i]){
                sum += scores.getOrDefault(s,0);
            }
            answer[i]=sum;
        }
        return answer;
    }
}