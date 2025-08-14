import java.util.*;
import java.util.stream.*;

class Solution {
    static long answer = 0;
    public long solution(String expression) {
        int len=expression.length();
        List<Long> num=new LinkedList<>();
        List<String> ope=new LinkedList<>();
        int idx=0;
        for(int i=0;i<len;i++){
            char cur=expression.charAt(i);
            if(cur=='*'||cur=='-'||cur=='+'){
                num.add(Long.parseLong(expression.substring(idx,i)));
                ope.add(String.valueOf(cur));
                idx=i+1;
            }
        }
        num.add(Long.parseLong(expression.substring(idx)));
    
        cal(num,ope,"+","-","*");
        cal(num,ope,"+","*","-");
        cal(num,ope,"-","+","*");
        cal(num,ope,"-","*","+");
        cal(num,ope,"*","-","+");
        cal(num,ope,"*","+","-");
        
        return answer;
    }
    
    public void cal(List<Long> num,List<String> ope, String first,String second, String third){
        
        List<Long> copyNum = num.stream().collect(Collectors.toList());
        List<String> copyOpe = ope.stream().collect(Collectors.toList());
        Long result=0L;
        int idx=0;
        while(!copyOpe.isEmpty()){
            idx=copyOpe.indexOf(first);
            if(idx==-1) idx=copyOpe.indexOf(second);
            if(idx==-1) idx=copyOpe.indexOf(third);
            
            Long num1=copyNum.remove(idx);
            Long num2=copyNum.remove(idx);
            String curOpe=copyOpe.remove(idx);
            
            if(curOpe.equals("+")){
                result=num1+num2;
                copyNum.add(idx,result);
            }
            else if(curOpe.equals("-")){
                result=num1-num2;
                copyNum.add(idx,result);
            }
            else{
                result=num1*num2;
                copyNum.add(idx,result);
            }
            
        }
        answer=Long.max(answer,(Long)Math.abs(result));
    }
    
}