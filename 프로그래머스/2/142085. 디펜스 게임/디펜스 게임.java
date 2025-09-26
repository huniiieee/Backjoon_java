import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        return binarySearch(enemy, k, n);
    }
    
    public long check(int range, int[] enemy, int k) {
        int[] temp = new int[range + 1];
        for (int i = 0; i <= range; i++) {
            temp[i] = enemy[i];
        }
        Arrays.sort(temp);
        
        long sum = 0;  // long으로 변경
        for (int i = 0; i <= range - k; i++) {
            sum += temp[i];
        }
        return sum;
    }
    
    public int binarySearch(int[] enemy, int k, int n) {
        int left = 0;
        int right = enemy.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            long temp = check(mid, enemy, k); 
            if (temp <= n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
