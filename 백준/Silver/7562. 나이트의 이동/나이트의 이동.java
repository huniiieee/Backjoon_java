
import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int L;
    public static int startx;
    public static int starty;
    public static int endx;
    public static int endy;
    public static String []input;
    public static boolean[][]visited;

    public static int [] dx={-2,-1,1,2,2,1,-1,-2};
    public static int [] dy={-1,-2,-2,-1,1,2,2,1};

    public static int bfs(){
        visited[startx][starty]=true;
        if(startx==endx&&starty==endy){
            return 0;
        }
        Queue<int []> q=new LinkedList<>();
        q.offer(new int[]{startx,starty,0});
        while(!q.isEmpty()){
            int [] cur= q.poll();
            int x=cur[0];
            int y=cur[1];
            int cnt=cur[2];

            for (int i = 0; i < 8; i++) {
                int cx=x+dx[i];
                int cy=y+dy[i];
                if(cx>=0&&cx<L&&cy>=0&&cy<L&&!visited[cx][cy]){
                    if(cx==endx&&cy==endy){
                        return cnt+1;
                    }
                    q.offer(new int[]{cx,cy,cnt+1});
                    visited[cx][cy]=true;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            L= Integer.parseInt(br.readLine());
            visited= new boolean[L][L];
            input= br.readLine().split(" ");
            startx= Integer.parseInt(input[0]);
            starty= Integer.parseInt(input[1]);
            input= br.readLine().split(" ");
            endx= Integer.parseInt(input[0]);
            endy= Integer.parseInt(input[1]);
            bw.write(String.valueOf(bfs())+"\n");
        }
        
        bw.flush();
        bw.close();
    }
}
