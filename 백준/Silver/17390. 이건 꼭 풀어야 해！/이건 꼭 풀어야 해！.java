import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int Q;

    public static void main(String[] args) throws IOException {
        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        Q=Integer.parseInt(input[1]);


        short [] sequence=new short[N];
        int [] sum=new int[N+1];
        input=br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            sequence[i]=Short.parseShort(input[i]);
        }
        Arrays.sort(sequence);
        sum[0]=0;
        int temp=0;
        for (int i = 0; i < N; i++) {
            temp +=sequence[i];
            sum[i+1]=temp;
        }
        for (int i = 0; i < Q; i++) {
            input=br.readLine().split(" ");
            int start=Integer.parseInt(input[0]);
            int end=Integer.parseInt(input[1]);
            bw.write(sum[end]-sum[start-1]+"\n");
        }

        bw.flush();
        bw.close();
    }
}