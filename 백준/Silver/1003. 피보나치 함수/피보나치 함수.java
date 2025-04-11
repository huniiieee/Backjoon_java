import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int T;
    public static int N;
    
    public static void main(String[] args) throws IOException {
        T=Integer.parseInt(br.readLine());
        int [][]dp=new int[41][2];
        dp[0][0]=1;
        dp[0][1]=0;
        dp[1][0]=0;
        dp[1][1]=1;
        for(int i=2;i<=40;i++){
            dp[i][0]=dp[i-1][0]+dp[i-2][0];
            dp[i][1]=dp[i-1][1]+dp[i-2][1];
        }
        for(int i=0;i<T;i++){
            N=Integer.parseInt(br.readLine());
            bw.write(dp[N][0]+" "+dp[N][1]+"\n");
        }
        bw.flush();
        bw.close();
    }
}