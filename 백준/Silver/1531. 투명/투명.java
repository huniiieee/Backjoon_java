import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);

        int [][] image=new int[100][100];
        int result=0;
        for (int i = 0; i < N; i++) {
            input=br.readLine().split(" ");
            int x1=Integer.parseInt(input[0])-1;
            int y1=Integer.parseInt(input[1])-1;
            int x2=Integer.parseInt(input[2])-1;
            int y2=Integer.parseInt(input[3])-1;

            for (int j = x1; j <=x2 ; j++) {
                for (int k = y1; k <=y2 ; k++) {
                    image[j][k] +=1;
                }
            }
        }
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(image[i][j]>M) result+=1;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }





}
