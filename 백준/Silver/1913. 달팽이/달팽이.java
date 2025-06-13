import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int target;

    public static int[][] dr={{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        target=Integer.parseInt(br.readLine());

        int start=N*N;
        int r=0;
        int c=0;
        int d=0;

        int resultR=0;
        int resultC=0;

        int[][]map=new int[N][N];
        boolean [][]visited=new boolean[N][N];
        while(start>=1){
            map[r][c]=start;
            visited[r][c]=true;
            if(start==target){
                resultR=r+1;
                resultC=c+1;
            }
            if(!check(r,c,d,visited)) d=(d+1)%4;

            r=r+dr[d][0];
            c=c+dr[d][1];

            start --;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(map[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.write(resultR+" "+resultC);
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean check(int r,int c,int d, boolean [][]visited){
        int nr=r+dr[d][0];
        int nc=c+dr[d][1];
        if(!(nr>=0&&nr<N&&nc>=0&&nc<N)) return false;
        return !visited[nr][nc];
    }
}
