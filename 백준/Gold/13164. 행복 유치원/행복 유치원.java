
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int K;



    public static void main(String[] args) throws IOException {

        String [] input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        K=Integer.parseInt(input[1]);
        int [] diff=new int[N-1];
        input=br.readLine().split(" ");
        for (int i = 0; i < N-1 ; i++) {
            diff[i]=Integer.parseInt(input[i+1])-Integer.parseInt(input[i]);
        }
        int result=0;
        Arrays.sort(diff);
        for (int i = 0; i < N-K; i++) {
            result+=diff[i];
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
