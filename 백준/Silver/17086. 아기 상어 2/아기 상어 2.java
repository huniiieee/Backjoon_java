
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int M;

    public static int result=Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {


        String [] input= br.readLine().split(" ");

        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);

        List<int []> shark=new ArrayList<>();
        for (int i = 0; i < N; i++) {
            input=br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                if(input[j].equals("1")){
                    shark.add(new int[]{i,j});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int temp=Integer.MAX_VALUE;
                for (int[] ints : shark) {
                    int x=ints[0];
                    int y=ints[1];
                    int dis=Integer.max(Math.abs(i-x),Math.abs(j-y));
                    temp=Integer.min(temp,dis);
                }
                result=Integer.max(result,temp);
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
