import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int M;
    public static int N;

    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        List<List<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            input=br.readLine().split(" ");
            int start= Integer.parseInt(input[0])-1;
            int end= Integer.parseInt(input[1])-1;
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        int result=0;
        boolean []visited=new boolean[N];
        for (int i = 0; i < N; i++) {
            if(visited[i])
                continue;
            result++;
            Queue<Integer> q=new LinkedList<>();
            q.offer(i);
            visited[i]=true;
            while(!q.isEmpty()){
                int cur=q.poll();
                for (Integer integer : graph.get(cur)) {
                    if(!visited[integer]) {
                        visited[integer] = true;
                        q.offer(integer);
                    }
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
