import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int M;

    public static void backtracking(int[]number,boolean[]visited,String temp,int cnt) throws IOException {
        if(cnt==M){
            bw.write(temp+"\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i]=true;
                if (cnt == 0) {
                    backtracking(number, visited, "" + number[i], cnt + 1);
                } else {
                    backtracking(number, visited, temp + " " + number[i], cnt + 1);
                }
                visited[i]=false;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [] number=new int[N];
        for (int i = 0; i <N ; i++) {
            number[i]=i+1;
        }
        boolean []visited=new boolean[N];

        backtracking(number,visited,"",0);
        bw.flush();
        bw.close();
    }

}