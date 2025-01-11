
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
        for (int i = 0; i < N; i++) {
            height[i]=Integer.parseInt(input[i]);
        }
        int result=Integer.MIN_VALUE;

        for (int i = 0; i < N-1; i++) {
            int temp=0;
            int next=0;
            for (int j = i+1; j < N; j++) {
                if(height[j]>height[i])
                    break;
                else{
                    temp++;
                    next++;
                }

            }
            i+=next;
            result=Integer.max(result,temp);
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
