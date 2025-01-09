
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;



    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        int [] distance=new int[N-1];
        int [] cost=new int[N-1];
        String [] input= br.readLine().split(" ");
        for (int i = 0; i < N-1; i++) {
            distance[i]=Integer.parseInt(input[i]);
        }
        input=br.readLine().split(" ");
        for (int i = 0; i < N-1; i++) {
            cost[i]=Integer.parseInt(input[i]);
        }

        int min=Integer.MAX_VALUE;
        long result=0;
        for (int i = 0; i < N-1; i++) {
            min=Integer.min(min,cost[i]);
            result +=(long)min*distance[i];
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
