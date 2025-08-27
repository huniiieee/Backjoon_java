import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int min = Integer.MAX_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < stones.length; i++) {
            while (!dq.isEmpty() && stones[dq.peekLast()] <= stones[i]) dq.pollLast();
            dq.addLast(i);

            if (dq.peekFirst() <= i - k) dq.pollFirst();

            if (i >= k - 1) min = Math.min(min, stones[dq.peekFirst()]);
        }

        return min;
    }
    

}