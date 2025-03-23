import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int []dx={-1,0,1,0};
    public static int []dy={0,1,0,-1};

    static class Migration{
        public int N;
        public int L;
        public int R;
        public int[][]map;

        Migration(int n, int l, int r){
            this.N=n;
            this.L=l;
            this.R=r;
            map=new int[N][N];
        }

        public boolean isChange(){
            boolean answer=false;
            boolean [][]visited=new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i][j]) continue;

                    int sum=0;
                    int cnt=0;
                    Queue<int []> q=new LinkedList<>();
                    List<int []> list=new ArrayList<>();
                    q.offer(new int[]{i,j});
                    visited[i][j]=true;
                    while(!q.isEmpty()){
                        int []cur=q.poll();
                        int x=cur[0];
                        int y=cur[1];
                        cnt +=1;
                        sum +=map[x][y];
                        list.add(cur);
                        for (int k = 0; k < 4; k++) {
                            int nx=x+dx[k];
                            int ny=y+dy[k];
                            if(!(nx>=0&&ny>=0&&nx<N&&ny<N&&!visited[nx][ny])){
                                continue;
                            }
                            int diff=Math.abs(map[nx][ny]-map[x][y]);
                            if(diff>=L&&diff<=R){
                                q.offer(new int[]{nx,ny});
                                visited[nx][ny]=true;
                            }
                        }
                    }
                    if(cnt!=1){
                        int newPopulation=sum/cnt;
                        for (int[] place : list) {
                            map[place[0]][place[1]]=newPopulation;
                        }
                        answer=true;
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) throws IOException {
        String []input=br.readLine().split(" ");
        Migration migration=new Migration(Integer.parseInt(input[0]),Integer.parseInt(input[1]),Integer.parseInt(input[2]));
        for (int i = 0; i < migration.N ; i++) {
            input=br.readLine().split(" ");
            for (int j = 0; j < migration.N ; j++) {
                migration.map[i][j]=Integer.parseInt(input[j]);
            }
        }
        int result=0;
        while(migration.isChange()){
            result++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }




}