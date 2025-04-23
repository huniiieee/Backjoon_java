
import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;


    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        long [] sum= new long[N];
        for(int i=0;i<N;i++){
            String []input=br.readLine().split(" ");
            int n=Integer.parseInt(input[0]);
            for(int j=1;j<=n;j++){
                sum[i] +=Long.parseLong(input[j]);
            }
        }
        Arrays.sort(sum);
        long result=0;
        for(int i=0;i<N;i++){
            result += sum[i]*(N-i);
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }


}