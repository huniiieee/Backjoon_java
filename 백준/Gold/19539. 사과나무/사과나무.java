
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;



    public static void main(String[] args) throws IOException {


        N=Integer.parseInt(br.readLine());
        int [] height=new int[N];
        String [] input=br.readLine().split(" ");


        int sum=0;
        int divide2=0;
        for (int i = 0; i < N; i++) {
            height[i]=Integer.parseInt(input[i]);
            sum +=height[i];
            divide2 +=height[i]/2;
        }
        boolean result=true;

        if(sum%3!=0||divide2<sum/3){
            result=false;
        }

        bw.write(result ? "YES" : "NO");
        bw.flush();
        bw.close();
    }
}
