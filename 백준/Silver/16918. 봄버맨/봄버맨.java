import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int R, C, N;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static char[][] simulate(char[][] initial) {
        if (N == 1) return initial;
        if (N % 2 == 0) {
            char[][] full = new char[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    full[i][j] = 'O';
                }
            }
            return full;
        }
        
        char[][] state2 = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                state2[i][j] = 'O';
            }
        }
        
        char[][] state3 = explode(state2, initial);
        
        if (N % 4 == 3) return state3;

        return explode(state2, state3);
    }
    
    public static char[][] explode(char[][] full, char[][] bombPos) {
        char[][] result = new char[R][C];
        for (int i = 0; i < R; i++) {
            System.arraycopy(full[i], 0, result[i], 0, C);
        }
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bombPos[i][j] == 'O') {
                    result[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
                            result[ni][nj] = '.';
                        }
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        N = Integer.parseInt(input[2]);
        
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        
        char[][] result = simulate(map);
        
        for (int i = 0; i < R; i++) {
            bw.write(result[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
