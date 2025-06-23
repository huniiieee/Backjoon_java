import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int H;
    public static int W;

    public static void main(String[] args) throws IOException {
        String []input=br.readLine().split(" ");
        H=Integer.parseInt(input[0]);
        W=Integer.parseInt(input[1]);
        int [][]blocks=new int[H][W];

        input=br.readLine().split(" ");
        for (int i = 0; i < W; i++) {
            int h=Integer.parseInt(input[i]);
            for (int j = H-h; j < H; j++) {
                blocks[j][i]=1;
            }
        }

        int result= rain(blocks);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static int rain(int [][]blocks){
        int cnt=0;
        int startIndex=0;
        for (int i = 0; i < H; i++) {
            boolean flag=false;

            for (int j = 0; j < W; j++) {

                if(blocks[i][j]==1 && !flag){
                    flag =true;
                    startIndex=j+1;
                }
                else if(blocks[i][j]==1 && flag){
                    cnt +=(j-startIndex);
                    startIndex=j+1;
                }
            }
        }
        return cnt;
    }

}