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

        int []maxWeight= new int[K+1];
        

        for (int i = 0; i < N; i++) {
            input=br.readLine().split(" ");
            int weight=Integer.parseInt(input[0]);
            int value=Integer.parseInt(input[1]);
            for (int j = K; j >=weight; j--) {
                if(maxWeight[j-weight]==-1) continue;
                maxWeight[j]=Integer.max(maxWeight[j],maxWeight[j-weight]+value);
            }
        }
        bw.write(maxWeight[K]+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
