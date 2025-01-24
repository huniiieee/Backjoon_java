
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int K;

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        boolean []prime=new boolean[N+1];
        int check=0;
        int result=0;
        boolean flag=false;
        for (int i = 2; i<=N ; i++) {
            if(flag)
                break;
            if(!prime[i]){
                check++;
                if(check==K)
                {
                    result=i;
                    break;
                }
                for (int j = i*i; j <=N; j=j+i) {
                    if(prime[j])
                        continue;
                    prime[j]=true;
                    check++;
                    if(check==K){
                        result=j;
                        flag=true;
                        break;
                    }
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

}
