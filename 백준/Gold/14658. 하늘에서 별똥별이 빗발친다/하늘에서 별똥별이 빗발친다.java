import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int M;
    public static int L;
    public static int K;
    public static int result=Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);
        L=Integer.parseInt(input[2]);
        K=Integer.parseInt(input[3]);
        int [][] stars=new int[K][2];
        for(int i=0;i<K;i++){
            input=br.readLine().split(" ");
            stars[i][0]=Integer.parseInt(input[0]);
            stars[i][1]=Integer.parseInt(input[1]);
        }

        for(int i=0;i<K;i++){
            for(int j=0;j<K;j++){
                int x=stars[i][0];
                int y=stars[j][1];
                result=Integer.min(result,count(stars,x,y));
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static int count(int [][]stars,int x,int y){
        int cnt=0;
        for(int i=0;i<K;i++){
            int checkX=stars[i][0];
            int checkY=stars[i][1];
            if(checkX<x||checkX>x+L||checkY<y||checkY>y+L){
                cnt++;
            }
        }
        return cnt;
    }
}