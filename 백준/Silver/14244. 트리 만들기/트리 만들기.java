
import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int M;



    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);
        bw.write("0 1\n");
        for(int i=2;i<=M;i++){
            bw.write(1+" "+i+"\n");
        }
        for(int i=M;i<=N-2;i++){
            bw.write(i+" "+(i+1)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }


}