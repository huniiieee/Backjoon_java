import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;




    public static void main(String[] args) throws IOException {
        long sum=0;
        long squareSum=0;
        N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            long num=Long.parseLong(st.nextToken());
            sum +=num;
            squareSum +=(num*num);
        }

        bw.write(String.valueOf((sum*sum-squareSum)/2));
        bw.flush();
        bw.close();
    }


}