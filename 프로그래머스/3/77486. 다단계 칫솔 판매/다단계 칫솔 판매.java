import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String,String> people= new HashMap<>();
        Map<String,Integer> money=new HashMap<>();
        
        for(int i=0;i<enroll.length;i++){
            people.put(enroll[i],referral[i]);
        }
        
        for(int i=0;i<seller.length;i++){
            int won=amount[i]*100;
            String person=seller[i];
            while(won!=0){
                if(person.equals("-")) break;
                int next=won/10;
                if(next==0){
                    money.put(person,money.getOrDefault(person,0)+won);
                    break;
                }
                else{
                    money.put(person,money.getOrDefault(person,0)+won-next);
                    won=next;
                    person=people.get(person);
                }
            }
        }
        
        int len= enroll.length;
        int[] answer = new int[len];
        for(int i=0;i<len;i++){
            answer[i]=money.getOrDefault(enroll[i],0);
        }
        return answer;
    }
}