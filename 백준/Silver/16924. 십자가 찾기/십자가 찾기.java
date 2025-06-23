import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int M;
    public static int[] dx={-1,0,1,0};
    public static int[] dy={0,1,0,-1};



    public static void main(String[] args) throws IOException {
        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);

        char [][]map=new char[N][M];
        for (int i = 0; i < N; i++) {
            String temp=br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j]=temp.charAt(j);
            }
        }
        List<int []> list=new LinkedList<>();
        boolean [][]visited=new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]=='*'){
                    int checked=check(map,visited,i,j);
                    if(checked==-1) continue;
                    else list.add(new int[]{i+1,j+1,checked});
                }
            }
        }


        int size=list.size();

        for (int i = 0; i < N; i++) {
            boolean flag=false;
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '*' && !visited[i][j]) {
                    size = 0;
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }
        if(size==0) bw.write(String.valueOf(-1));
        else {
            bw.write(size+"\n");
            for(int []temp:list){
                bw.write(temp[0]+" "+temp[1]+" "+temp[2]+"\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static int check(char [][]map,boolean [][]visited,int r,int c){
        int i=1;
        for (i = 1;  ; i++) {
            boolean flag=false;
            for (int j = 0; j < 4; j++) {
                int dr=r+dx[j]*i;
                int dc=c+dy[j]*i;
                if(dr>=0&&dr<N&&dc>=0&&dc<M&&map[dr][dc]=='*') continue;
                else {
                    flag=true;
                    break;
                }
            }
            if(flag)
                break;
        }
        if(i!=1){
            int size=i-1;
            visited[r][c]=true;
            for (int j = 1; j <= size; j++) {
                for (int k = 0; k < 4; k++) {
                    int dr=r+dx[k]*j;
                    int dc=c+dy[k]*j;
                    visited[dr][dc]=true;
                }
            }
        }

        return (i==1) ? -1 : (i-1);
    }
}