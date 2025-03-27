import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;



    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());

        int [] dp=new int[N+1];
        Arrays.fill(dp,-1);
        dp[3]=1;
        if(N>=5)
            dp[5]=1;
        for (int i = 6; i <=N ; i++) {
            if(dp[i-3]==-1 &&dp[i-5]==-1){
                dp[i]=-1;
            }
            else if(dp[i-3]==-1 ||dp[i-5]==-1){
                dp[i]=dp[i-3]+dp[i-5]+2;
            }
            else{
                dp[i]=Integer.min(dp[i-3],dp[i-5])+1;
            }
        }
        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close();
    }


}