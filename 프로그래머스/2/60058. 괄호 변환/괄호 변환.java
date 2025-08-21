import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        answer=bracket(p);
        
        return answer;
    }
    
    public String bracket(String s){
        if(s.equals("")){
            return "";
        }
        String [] split= split(s);
        if(check(split[0])){
            return split[0]+bracket(split[1]);
        }
        else{
            return "("+bracket(split[1])+")"+ trimAndReverse(split[0]);
        }
        
    }
    
    public boolean check(String s){
        int []temp= change(s);
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<temp.length;i++){
            if(temp[i]==0) stack.push(temp[i]);
            else{
                if(stack.isEmpty()) return false;
                int peek=stack.pop();
                if(peek==1) return false;
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
    
    public int[] change(String s){
        int len=s.length();
        int [] brackets=new int[len];
        for(int i=0;i<len;i++){
            brackets[i]= (s.charAt(i)=='(') ? 0 : 1; ;
        }
        return brackets;
    }
    
    public String [] split(String s){
        String []result=new String[2];
        int []temp= change(s);
        int zeroCnt=0;
        int oneCnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                zeroCnt++;
            }
            else{
                oneCnt++;
            }
            if(zeroCnt!=0&&zeroCnt==oneCnt){
                result[0]=s.substring(0,i+1);
                result[1]=s.substring(i+1);
                break;
            }
        }
        return result;
        
    }
    
    public String trimAndReverse(String s){
        int []temp= change(s);
        for(int i=0;i<temp.length;i++){
            temp[i] = (temp[i]+1)%2;
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<temp.length-1;i++){
            sb.append((temp[i]==0) ? '(' : ')');
        }
        return sb.toString();
    }
}