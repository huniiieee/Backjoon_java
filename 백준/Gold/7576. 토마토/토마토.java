import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int M;
    public static int N;

    public static int[] dx={-1,0,1,0};
    public static int[] dy={0,-1,0,1};

    public static boolean checkTomato(int [][]tomato){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tomato[i][j]==-1)
                    continue;
                boolean check=true;
                for (int k = 0; k < 4; k++) {
                    int cx=i+dx[k];
                    int cy=j+dy[k];
                    if(cx>=0&&cx<N&&cy>=0&&cy<M&&tomato[cx][cy]!=-1){
                        check=false;
                        break;
                    }
                }
                if(check){
                    return true;
                }

            }
        }
        return false;
    }

    public static int bfs(int [][]tomato,Queue<int []> q,int unTomato){
        while(!q.isEmpty()){
            int []cur=q.poll();
            int x=cur[0];
            int y=cur[1];
            int cnt=cur[2];
            for(int i=0;i<4;i++){
                int cx=x+dx[i];
                int cy=y+dy[i];
                if(cx>=0&&cx<N&&cy>=0&&cy<M&&tomato[cx][cy]==0){
                    q.offer(new int[]{cx,cy,cnt+1});
                    tomato[cx][cy]=1;
                    unTomato--;
                }
            }
            if(unTomato==0)
                return cnt+1;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        int [][]tomato=new int[N][M];
        Queue<int []> q=new LinkedList<>();
        int unTomato=0;
        for (int i = 0; i < N; i++) {
            input=br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                tomato[i][j]=Integer.parseInt(input[j]);
                if(tomato[i][j]==1){
                    q.offer(new int[]{i,j,0});
                }
                if(tomato[i][j]==0){
                    unTomato++;
                }
            }
        }

        if(unTomato==0){
            bw.write(String.valueOf(0));
            bw.flush();
            bw.close();
            return;
        }
       
        bw.write(String.valueOf(bfs(tomato,q,unTomato)));
        bw.flush();
        bw.close();
    }
}
