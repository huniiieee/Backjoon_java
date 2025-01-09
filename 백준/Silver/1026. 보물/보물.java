
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;



    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        String []input=br.readLine().split(" ");
        Byte [] A=new Byte[N];
        Byte [] B=new Byte[N];
        for (int i = 0; i < N; i++) {
            A[i]=Byte.parseByte(input[i]);
        }
        input=br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            B[i]=Byte.parseByte(input[i]);
        }
        Arrays.sort(A);
        Arrays.sort(B,(a,b)->b-a);
        int result=0;
        for (int i = 0; i < N; i++) {
            result += A[i]*B[i];
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
