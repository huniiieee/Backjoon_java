import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static long N;


    public static void main(String[] args) throws IOException {
        N=Long.parseLong(br.readLine());
        long result=1;

        while((result*(result+1))/2<=N){
            result++;
        }

        bw.write(String.valueOf(result-1));
        bw.flush();
        bw.close();
    }



}