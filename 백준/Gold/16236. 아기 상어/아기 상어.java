import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int size=2;
    public static int eat=0;
    public static int startX,startY;

    public static int[] dx={-1,0,0,1};
    public static int[] dy={0,-1,1,0};

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        int [][]map=new int[N][N];
        for(int i=0;i<N;i++){
            String []input=br.readLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(input[j]);
                if(map[i][j]==9){
                    startX=i;
                    startY=j;
                    map[i][j]=0;
                }
            }
        }
        bw.write(String.valueOf(BFS(map)));
        bw.flush();
        bw.close();
    }

    public static int BFS(int [][]map){
        boolean [][]visited=new boolean[N][N];
        PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparingInt((int[] arr) -> arr[0]).thenComparing(arr->arr[1]).thenComparing(arr->arr[2]));
        visited[startX][startY]=true;
        queue.add(new int[]{0,startX,startY});
        int result=0;
        while(!queue.isEmpty()){
            int []cur=queue.poll();
            int cnt=cur[0];
            int x=cur[1];
            int y=cur[2];
            //먹을 수 있는 물고기
            if(map[x][y]!=0&&map[x][y]<size){
                result += cnt;  //시간 증가
                eat ++;             //먹은 물고기 증가
                if(eat==size){      //크기만큼 먹으면 크기 증가
                    size++;
                    eat=0;
                }
                map[x][y]=0;      //먹은 물고기 빈 칸 대체
                queue.clear();      //큐 초기화
                queue.add(new int[]{0,x,y});  //먹은 곳에서 다시 시작
                visited=new boolean[N][N];      //방문 초기화
                visited[x][y]=true;           //먹은 곳 방문
                continue;
            }
            //먹지 못하고 이동만 가능한 물고기
            for (int i = 0; i < 4; i++) {
                int cx=x+dx[i];
                int cy=y+dy[i];
                if(cx>=0&&cx<N&&cy>=0&&cy<N&&!visited[cx][cy]&&map[cx][cy]<=size){
                    visited[cx][cy]=true;
                    queue.add(new int[]{cnt+1,cx,cy});
                }
            }
        }
        return result;
    }


}