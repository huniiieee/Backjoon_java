
// don't place package name.
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int M;

    public static int min=Integer.MAX_VALUE;

    public static void backtracking(List<int[]> chicken, List<int[]> house, boolean[] visited, int cnt, int start) {
        if (cnt == M) {
            int sum = 0;
            for (int[] h : house) {
                int dis = Integer.MAX_VALUE;
                for (int i = 0; i < chicken.size(); i++) {
                    if (visited[i]) {
                        dis = Math.min(dis, Math.abs(chicken.get(i)[0] - h[0]) + Math.abs(chicken.get(i)[1] - h[1]));
                    }
                }
                sum += dis;
            }
            min = Math.min(min, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(chicken, house, visited, cnt + 1, i + 1); // 시작점을 i+1로 제한
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        String [] input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);
        int temp=0;
        List<int []> house=new ArrayList<>();
        List<int []> chicken=new ArrayList<>();


        for (int i = 0; i < N; i++) {
            input=br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                temp=Integer.parseInt(input[j]);
                if(temp==1)
                    house.add(new int[]{i,j});
                else if(temp==2)
                    chicken.add(new int[]{i,j});
            }
        }
        int []sum=new int[house.size()];
        Arrays.fill(sum,Integer.MAX_VALUE);
        boolean [] visited=new boolean[chicken.size()];
        backtracking(chicken,house,visited,0,0);
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}
