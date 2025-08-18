import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
class Solution {
    public int[] solution(String s) {
        String [] split=s.split("},");
        int len=split.length;
        for(int i=0;i<len;i++){
            split[i]=split[i].replaceAll("\\{","");
            split[i]=split[i].replaceAll("\\}","");
        }
        Arrays.sort(split, (a,b)->a.length()-b.length());
        Set<Integer> set=new HashSet<>();
        int[] answer = new int[len];
        for(int i=0;i<len;i++){
            String [] temp=split[i].split(",");
            for(String t :temp){
                int num=Integer.parseInt(t);
                if(set.contains(num)) continue;
                else{
                    set.add(num);
                    answer[i]=num;
                }
            }
        }
        return answer;
    }
}