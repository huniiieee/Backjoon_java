import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    static ArrayList<Integer> list;
    static boolean[] visited;
    static int[] map;

    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        map=new int[N+1];
        for (int i = 1; i <= N; i++) {
            map[i]=Integer.parseInt(br.readLine());
        }
        list = new ArrayList<>();
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        Collections.sort(list);
        bw.write(list.size()+"\n");
        for (Integer integer : list) {
            bw.write(integer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start, int target) {
        if(!visited[map[start]]) {
            visited[map[start]] = true;
            dfs(map[start], target);
            visited[map[start]] = false;
        }
        if(map[start] == target) list.add(target);
    }

}