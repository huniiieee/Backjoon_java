

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

        int [] temper= new int[N];
        input=br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            temper[i]=Integer.parseInt(input[i]);
        }
        int sum=0;

        for (int i = 0; i < K; i++) {
            sum +=temper[i];
        }
        int result=sum;

        for (int i = K; i < N; i++) {
            sum = sum+temper[i]-temper[i-K];
            result=Integer.max(sum,result);
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }


}
