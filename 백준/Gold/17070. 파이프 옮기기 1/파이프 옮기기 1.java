import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int cnt;

    // 파이프 방향: 0=가로, 1=대각선, 2=세로
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 위치: (0,0)-(0,1) → 끝 좌표는 (0,1), 방향은 가로(0)
        dfs(0, 1, 0);

        System.out.println(cnt);
    }

    static void dfs(int x, int y, int dir) {
        if (x == N - 1 && y == N - 1) {
            cnt++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            // 가로 상태에서 세로 이동 불가
            if (dir == 0 && i == 2) continue;
            // 세로 상태에서 가로 이동 불가
            if (dir == 2 && i == 0) continue;

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (i == 1) { // 대각선 이동 시
                if (nx >= N || ny >= N) continue;
                if (map[nx][ny] == 1 || map[nx - 1][ny] == 1 || map[nx][ny - 1] == 1) continue;
            } else { // 가로, 세로 이동 시
                if (nx >= N || ny >= N) continue;
                if (map[nx][ny] == 1) continue;
            }

            dfs(nx, ny, i);
        }
    }
}
