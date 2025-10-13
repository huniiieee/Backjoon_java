import java.util.*;
class Solution {
    static Map<String, Object> bfs(List<List<Integer>> roomTmp, int n) {
        List<List<Integer>> room = new ArrayList<>();
        for (int i = 0; i < n; i++) room.add(new ArrayList<>());

        int[] indegree = new int[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : roomTmp.get(cur)) {
                if (visited[next]) continue;
                room.get(cur).add(next);
                indegree[next]++;
                visited[next] = true;
                q.add(next);
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("room", room);
        result.put("indegree", indegree);
        return result;
    }
    
    public boolean solution(int n, int[][] path, int[][] order) {
        List<List<Integer>> roomTmp = new ArrayList<>();
        for (int i = 0; i < n; i++) roomTmp.add(new ArrayList<>());

        for (int[] p : path) {
            int a = p[0], b = p[1];
            roomTmp.get(a).add(b);
            roomTmp.get(b).add(a);
        }

        Map<String, Object> bfsResult = bfs(roomTmp, n);
        List<List<Integer>> room = (List<List<Integer>>) bfsResult.get("room");
        int[] indegree = (int[]) bfsResult.get("indegree");

        for (int[] o : order) {
            int a = o[0], b = o[1];
            room.get(a).add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        for (int i = 0; i < n; i++) {
            if (q.isEmpty()) return false;  
            int cur = q.poll();
            for (int next : room.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);
            }
        }

        return true;
    }
}