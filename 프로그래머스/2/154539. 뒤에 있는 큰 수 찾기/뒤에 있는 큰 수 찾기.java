import java.util.Stack;
class Solution {
    public int[] solution(int[] numbers) {
        int len=numbers.length;
        
        int[] answer = new int[len];
        Stack<Integer> stack=new Stack<>();
        
        stack.push(numbers[len-1]);
        answer[len-1]=-1;
        
        for(int i=len-2;i>=0;i--){
            int cur=numbers[i];
            
            if(cur<numbers[i+1]) answer[i]=numbers[i+1];
            else{
                while(!stack.isEmpty()){
                    if(stack.peek()>cur){
                        answer[i]=stack.peek();
                        break;
                    }
                    else{
                        stack.pop();
                    }
                    if(stack.isEmpty())
                        answer[i]=-1;
                }
            }
            stack.push(cur);
        }
        return answer;
    }
   
}