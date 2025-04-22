
import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;


    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        int [][]map=new int[N][N];
        for (int i = 0; i < N; i++) {
            String input=br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j]=Character.getNumericValue(input.charAt(j));
            }
        }
        divide(map,0,0,N);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void divide(int[][]map,int r,int c,int size) throws IOException
    {
        if(size==1 || check(map,r,c,size)){
            bw.write(String.valueOf(map[r][c]));
            return;
        }

        bw.write("(");
        int nextSize=size/2;
        divide(map,r,c,nextSize);
        divide(map,r,c+nextSize,nextSize);
        divide(map,r+nextSize,c,nextSize);
        divide(map,r+nextSize,c+nextSize,nextSize);
        bw.write(")");

    }


    public static boolean check(int [][]map,int r,int c,int size){
        int value=map[r][c];
        boolean flag=true;
        for(int i=r;i<r+size;i++){
            for(int j=c;j<c+size;j++){
                if(map[i][j]!=value)
                {
                    flag=false;
                    break;
                }
            }
            if(!flag) break;
        }
        return flag;
    }
}