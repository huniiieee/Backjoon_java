

import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int result = 0;

    public static void backtracking(int row, int[] col) {
        if (row == N) {
            result++;
            return;
        }
        
        for (int j = 0; j < N; j++) {
            boolean isSafe = true;
            for (int i = 0; i < row; i++) {
                
                if (col[i] == j || Math.abs(row - i) == Math.abs(j - col[i])) {
                    isSafe = false;
                    break;
                }
            }
            if (isSafe) {
                col[row] = j; 
                backtracking(row + 1, col); 
                col[row] = -1; 
            }
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int[] col = new int[N];
        Arrays.fill(col, -1);

        backtracking(0, col);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
