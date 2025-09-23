import java.util.*;

class Solution {
    public List<String> solution(String[][] plans) {
        int n = plans.length;
        List<String> answer = new ArrayList<>();
        Stack<String[]> stack = new Stack<>();
        
        Arrays.sort(plans, (a, b) -> getMinute(a[1]) - getMinute(b[1]));
        
        for (int i = 0; i < n - 1; i++) {
            int start = getMinute(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);
            int nextStart = getMinute(plans[i + 1][1]);
            
            if (start + playTime <= nextStart) {
                answer.add(plans[i][0]);
                
                int left = nextStart - (start + playTime);
                while (!stack.isEmpty() && left > 0) {
                    String[] prev = stack.pop();
                    String prevName = prev[0];
                    int prevTime = Integer.parseInt(prev[1]);
                    
                    if (prevTime <= left) {
                        left -= prevTime;
                        answer.add(prevName);
                    } else {
                        prev[1] = String.valueOf(prevTime - left);
                        stack.push(prev);
                        break;
                    }
                }
            } else {
                int remain = start + playTime - nextStart;
                stack.push(new String[]{plans[i][0], String.valueOf(remain)});
            }
        }
        
        answer.add(plans[n - 1][0]);
        
        while (!stack.isEmpty()) {
            answer.add(stack.pop()[0]);
        }
        
        return answer;
    }
    
    private int getMinute(String s) {
        String[] parts = s.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
