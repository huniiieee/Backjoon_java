import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int M;

    public static int[] dx ={0,-1,-1,-1,0,1,1,1};
    public static int[] dy ={-1,-1,0,1,1,1,0,-1};


    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);

        int [][]grid=new int[N][N];
        for (int i = 0; i < N; i++) {
            input=br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                grid[i][j]=Integer.parseInt(input[j]);
            }
        }

        List<int []> clouds=new LinkedList<>();
        Set<String>preClouds=new HashSet<>();
        clouds.add(new int[]{N-1,0});
        clouds.add(new int[]{N-1,1});
        clouds.add(new int[]{N-2,0});
        clouds.add(new int[]{N-2,1});

        for (int i = 0; i < M; i++) {
            input=br.readLine().split(" ");
            int dir=Integer.parseInt(input[0])-1;
            int dis=Integer.parseInt(input[1]);
            move(clouds,dir,dis);
            remove(clouds,preClouds,grid);
            copyWater(preClouds,grid);
            makeCloud(clouds,preClouds,grid);
        }

        bw.write(getResult(grid)+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void move(List<int []>clouds,int dir,int dis){

        for (int[] cloud : clouds) {
            int x = cloud[0];
            int y = cloud[1];

            int nx = (x + dx[dir] * dis + N * 25) % N;
            int ny = (y + dy[dir] * dis + N * 25) % N;

            cloud[0] = nx;
            cloud[1] = ny;
        }
    }

    public static void remove(List<int []>clouds,Set<String>preClouds,int [][]grid){
        preClouds.clear();
        for(int []cloud:clouds){
            int x=cloud[0];
            int y=cloud[1];

            grid[x][y] +=1;

            preClouds.add(x+","+y);
        }
        clouds.clear();
    }

    public static void copyWater(Set<String>preClouds,int [][]grid){
        for(String cloudPos : preClouds){
            String[] pos = cloudPos.split(",");
            int x = Integer.parseInt(pos[0]);
            int y = Integer.parseInt(pos[1]);
            for (int i = 1; i < 8; i+=2) {
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx<0||nx>=N||ny<0||ny>=N) continue;
                if(grid[nx][ny]>0) grid[x][y] +=1;
            }
        }
    }

    public static void makeCloud(List<int []>clouds,Set<String>preClouds,int [][]grid){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(grid[i][j]<2) continue;
                if(preClouds.contains(i+","+j)) continue;

                clouds.add(new int[]{i,j});
                grid[i][j] -=2;
            }
        }
    }

    public static int getResult(int[][]grid){
        int cnt=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt +=grid[i][j];
            }
        }
        return cnt;
    }
}