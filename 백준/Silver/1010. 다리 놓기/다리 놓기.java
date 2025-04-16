import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int T;
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {

        T=Integer.parseInt(br.readLine());

        int [][]dp=new int[31][31];
        for(int i=1;i<=30;i++){
            Arrays.fill(dp[i],1);
        }
        for(int i=2;i<=30;i++){
            for(int j=1;j<i;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }

        for (int i = 0; i < T; i++) {
            String []input=br.readLine().split(" ");
            int r=Integer.parseInt(input[0]);
            int n=Integer.parseInt(input[1]);
            bw.write(dp[n][r]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }


}