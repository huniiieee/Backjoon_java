
// don't place package name.
import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int M;

    public static void backtracking(StringBuilder temp,int cnt,int pre) throws IOException {
        if(cnt==M){
            bw.write(temp+"\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(i>=pre){
                int len=temp.length();
                if(cnt>0)
                    temp.append(" ");
                temp.append(i);
                backtracking(temp,cnt+1,i);
                temp.setLength(len);
            }

        }

    }
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        backtracking(new StringBuilder(),0,0);
        bw.flush();
        bw.close();
    }
}
