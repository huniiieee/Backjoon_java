import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> kinds = new HashSet<>(Arrays.asList(gems));
        int totalKinds = kinds.size();

        Map<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;

        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (true) {
            if (map.size() < totalKinds && right < gems.length) {
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }
            else if (map.size() == totalKinds) {
                if (right - left < minLength) {
                    minLength = right - left;
                    answer[0] = left + 1;
                    answer[1] = right;
                }
                map.put(gems[left], map.get(gems[left]) - 1);
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            }
            else {
                break;
            }
        }

        return answer;
    }
}
