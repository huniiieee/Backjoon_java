
import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int T;
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {

        T=Integer.parseInt(br.readLine());
        while(T-- >0){
            String [] input=br.readLine().split(" ");
            N=Integer.parseInt(input[0]);
            M=Integer.parseInt(input[1]);
            bw.write(N-1+"\n");
            for(int i=0;i<M;i++){
                br.readLine();
            }
        }
        bw.close();
        br.close();
    }


}