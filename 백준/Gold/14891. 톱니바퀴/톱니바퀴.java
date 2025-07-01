import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int K;

    public static void main(String[] args) throws IOException {

        int [][] wheels=new int[4][8];
        for (int i = 0; i < 4; i++) {
            String input=br.readLine();
            for (int j = 0; j <8 ; j++) {
                wheels[i][j]=input.charAt(j)-'0';
            }
        }
        K=Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String []temp=br.readLine().split(" ");
            int wheel=Integer.parseInt(temp[0])-1;
            int dir=Integer.parseInt(temp[1]);

            int []rotate=new int[4];
            rotate[wheel]  =dir;
            check(wheels,rotate,wheel);
            rotate(wheels,rotate);
        }
        int result=wheels[0][0]+wheels[1][0]*2 +wheels[2][0]*4 + wheels[3][0]*8;
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void check(int [][]wheels,int []rotate,int wheel){
        for (int i = wheel-1; i >=0 ; i--) {
            if(wheels[i][2]!=wheels[i+1][6]) rotate[i]=-rotate[i+1];
            else break;
        }

        for (int i = wheel+1; i < 4; i++) {
            if(wheels[i][6]!=wheels[i-1][2]) rotate[i]=-rotate[i-1];
            else break;
        }
    }

    public static void rotate(int [][]wheels,int []rotate){
        for (int i = 0; i <4 ; i++) {
            if(rotate[i]==1){
                int temp=wheels[i][7];
                for (int j = 7; j >0; j--) {
                    wheels[i][j]=wheels[i][j-1];
                }
                wheels[i][0]=temp;
            }
            else if(rotate[i]==-1){
                int temp=wheels[i][0];
                for (int j = 0; j < 7; j++) {
                    wheels[i][j]=wheels[i][j+1];
                }
                wheels[i][7]=temp;
            }
        }
    }

}
