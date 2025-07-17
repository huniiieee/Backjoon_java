import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;



    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        int max=0;
        int sum=0;
        String []input=br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int cur=Integer.parseInt(input[i]);
            max=Integer.max(max,cur);
            sum +=cur;
        }

        boolean flag=false;
        if(max>1440||sum>2880) flag=true;


        int result=flag?-1:Integer.max(max,(sum+1)/2);
        bw.write(result+"");


        bw.flush();
        bw.close();
        br.close();
    }

}
