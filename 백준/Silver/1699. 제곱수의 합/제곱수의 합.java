import java.io.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;


    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        int next=1;
        int []dp=new int[N+1];
        for (int i = 1; i <=N ; i++) {
            if(i!=next*next){
                int min=Integer.MAX_VALUE;
                for (int j = 1; j <=i/2 ; j++) {
                    min=Integer.min(min,dp[j]+dp[i-j]);
                }
                dp[i]=min;
                continue;
            }
            dp[i]=1;
            next++;
        }

        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close();
    }

}