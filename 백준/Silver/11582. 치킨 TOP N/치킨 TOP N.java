import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int K;


    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] taste = new int[N];
        for (int i = 0; i < N; i++) {
            taste[i] = Integer.parseInt(input[i]);
        }
        K = Integer.parseInt(br.readLine());
        int temp=N/K;
        int [] divide=new int[temp];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < temp; j++) {
                divide[j]=taste[i*temp+j];

            }
            Arrays.sort(divide);
            for (int j = 0; j < temp; j++) {
                bw.write(divide[j]+" ");
            }
        }
        bw.flush();
        bw.close();
    }
}
