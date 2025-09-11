import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
    int[] dy = {1, 0, -1, 0};
    
    class Node {
        int x, y, dir, cost;
        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    public int solution(int[][] board) {
        int N = board.length;
        int[][][] dist = new int[N][N][4]; // 방향별 최소 비용
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<4;i++){
            dist[0][0][i] = 0;
            q.offer(new Node(0, 0, i, 0));
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int cost = cur.cost;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N || board[ny][nx]==1) continue;

                int nc = cost + (dir == i ? 100 : 600); // 직선:100, 코너:600

                if(dist[ny][nx][i] > nc){
                    dist[ny][nx][i] = nc;
                    q.offer(new Node(nx, ny, i, nc));
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0;i<4;i++){
            answer = Math.min(answer, dist[N-1][N-1][i]);
        }

        return answer;
    }
}