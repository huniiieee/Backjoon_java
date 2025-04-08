import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int[]dx={-1,0,1,0};
    public static int[]dy={0,1,0,-1};
    public static List<Integer> result=new LinkedList<>();


    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        int [][]map=new int[N][N];
        for(int i=0;i<N;i++){
            String input=br.readLine();
            for(int j=0;j<N;j++){
                map[i][j]=Character.getNumericValue(input.charAt(j));
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1){
                    bfs(map,i,j);
                }
            }
        }

        bw.write(result.size()+"\n");
        Collections.sort(result);
        for (Integer integer : result) {
            bw.write(integer + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs(int [][]map,int r,int c){
        Queue<int []> q=new LinkedList<>();
        q.offer(new int[]{r,c});
        boolean [][]visited=new boolean[N][N];
        map[r][c]=2;
        visited[r][c]=true;
        int cnt=0;
        while(!q.isEmpty()){
            cnt++;
            int []cur=q.poll();
            int x=cur[0];
            int y=cur[1];
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]&&map[nx][ny]==1){
                    q.offer(new int[]{nx,ny});
                    map[nx][ny]=2;
                    visited[nx][ny]=true;
                }
            }
        }
        result.add(cnt);
    }

}