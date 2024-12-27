
// don't place package name.
import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int M;

    public static void backtracking(int[] number,boolean[]visited,StringBuilder temp,int cnt,int pre) throws IOException {
        if(cnt==M){
            bw.write(temp+"\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]&&number[i]>pre){
                visited[i]=true;
                int len=temp.length();
                if(cnt>0)
                    temp.append(" ");
                temp.append(number[i]);
                backtracking(number,visited,temp,cnt+1,number[i]);
                temp.setLength(len);
                visited[i]=false;
            }

        }

    }
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String [] input=br.readLine().split(" ");
        int []number=new int[N];
        for (int i = 0; i < N; i++) {
            number[i]=Integer.parseInt(input[i]);
        }
        Arrays.sort(number);
        boolean []visited=new boolean[N];
        backtracking(number,visited,new StringBuilder(),0,0);
        bw.flush();
        bw.close();
    }
}
