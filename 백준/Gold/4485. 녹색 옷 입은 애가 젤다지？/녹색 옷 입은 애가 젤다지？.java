import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int[] dx={-1,0,1,0};
    public static int[] dy={0,1,0,-1};
    public static void main(String[] args) throws IOException {
        int cnt=1;
        while(true){
            N=Integer.parseInt(br.readLine());
            if(N==0)    break;
            int [][]map=new int[N][N];
            for(int i=0;i<N;i++){
                String []input=br.readLine().split(" ");
                for(int j=0;j<N;j++){
                    map[i][j]=Integer.parseInt(input[j]);
                }
            }
            bw.write("Problem "+cnt+": "+dijstra(map)+"\n");
            cnt++;
        }
        bw.flush();
        bw.close();
    }
     public static int dijstra(int [][]map){
        int size=map.length;
        PriorityQueue<int []> priorityQueue = new PriorityQueue<>((a,b)->a[2]-b[2]);
        priorityQueue.offer(new int[]{0,0,map[0][0]});
        boolean [][]visited=new boolean[size][size];
        visited[0][0]=true;
        while(!priorityQueue.isEmpty()){
            int []cur= priorityQueue.poll();
            int x=cur[0];
            int y=cur[1];
            int dist=cur[2];
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=0&&nx<size&&ny>=0&&ny<size&&!visited[nx][ny]){
                    map[nx][ny]=dist+map[nx][ny];
                    visited[nx][ny]=true;
                    priorityQueue.offer(new int[]{nx,ny,map[nx][ny]});
                }
            }
        }
        return map[size-1][size-1];
     }
}