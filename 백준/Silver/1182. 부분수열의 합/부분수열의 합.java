
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int S;

    public static int result = 0;

    public static void backtracking(int []number,boolean[]visited , int pre, int sum) {
        if(sum==S)
        {
            if(pre!=-1)
                result++;
        }
        if(pre==N-1)
            return;

        for (int i = pre+1; i < N; i++) {
            if(!visited[i]){
                visited[i]=true;
                backtracking(number,visited,i,sum+number[i]);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String [] input=br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        input=br.readLine().split(" ");
        int []number=new int[N];
        for (int i = 0; i < N; i++) {
            number[i]=Integer.parseInt(input[i]);
        }
        boolean[]visited= new boolean[N];

        backtracking(number,visited,-1,0);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
