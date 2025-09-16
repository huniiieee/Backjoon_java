import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        Stack<Integer> stack = new Stack<>();
        int cur = k;

        for (String c : cmd) {
            char op = c.charAt(0);
            if (op == 'U' || op == 'D') {
                int x = Integer.parseInt(c.split(" ")[1]);
                while (x-- > 0) {
                    cur = (op == 'U') ? prev[cur] : next[cur];
                }
            } else if (op == 'C') {
                stack.push(cur);
                if (prev[cur] != -1) next[prev[cur]] = next[cur];
                if (next[cur] != -1) prev[next[cur]] = prev[cur];
                cur = (next[cur] != -1) ? next[cur] : prev[cur];
            } else { 
                int restore = stack.pop();
                if (prev[restore] != -1) next[prev[restore]] = restore;
                if (next[restore] != -1) prev[next[restore]] = restore;
            }
        }

        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        while (!stack.isEmpty()) {
            answer[stack.pop()] = 'X';
        }

        return new String(answer);
    }
}
