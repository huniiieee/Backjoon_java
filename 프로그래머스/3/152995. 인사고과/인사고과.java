import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] target = scores[0];
        
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        
        int maxScore2 = 0;
        int targetSum = target[0] + target[1];
        int rank = 1;
        
        for (int[] s : scores) {
            if (s[1] < maxScore2) {
                if (s == target) return -1; 
            } else {
                maxScore2 = Math.max(maxScore2, s[1]);
                if (s[0] + s[1] > targetSum) rank++;
            }
        }
        
        return rank;
    }
}
