import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int M;
    public static int cnt=0;
    public static int max=0;
    public static int[] dx={-1,0,1,0};
    public static int[] dy={0,1,0,-1};

    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);
        int [][]map=new int[N][M];
        for(int i=0;i<N;i++){
            input=br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(input[j]);
            }
        }
        boolean[][]visited=new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==1&&!visited[i][j]) max=Integer.max(max,bfs(map,visited,i,j));
            }
        }
        bw.write(cnt +"\n"+max);
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int[][]map,boolean[][]visited,int r,int c){
        cnt++;
        Queue<int []> queue=new LinkedList<>();
        queue.offer(new int[]{r,c});
        visited[r][c]=true;
        int area=0;
        while(!queue.isEmpty()){
            int []cur=queue.poll();
            area++;
            int dr=cur[0];
            int dc=cur[1];
            for(int i=0;i<4;i++){
                int nr=dr+dx[i];
                int nc=dc+dy[i];
                if(nr>=0&&nr<N&&nc>=0&&nc<M&&!visited[nr][nc]&&map[nr][nc]==1){
                    visited[nr][nc]=true;
                    queue.offer(new int[]{nr,nc});
                }

            }
        }
        return area;
    }
}