import java.util.Arrays;
class Solution {
    public int solution(int n, int k) {
        return (int) Arrays.stream(Integer.toString(n, k).split("0"))
                .filter(s -> !s.isEmpty() && !s.equals("1"))
                .mapToLong(Long::parseLong)
                .filter(num -> {
                    for (long i = 2; i * i <= num; i++)
                        if (num % i == 0) return false;
                    return true;
                })
                .count();
    }
}