
import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int M;
    public static int [] dx={-1,0,1,0};
    public static int [] dy={0,1,0,-1};
    public static int [][]map;

    public static class Robot{
        int x,y,direction,cnt;

        public Robot(int x, int y, int direction){
            this.x=x;
            this.y=y;
            this.direction=direction;
            this.cnt=0;
        }

        public void cleaning(){
            if(map[x][y]==0){
                this.cnt++;
                map[x][y]=2;
            }

        }

        public boolean move(){
            boolean flag=false;
            for(int i=0;i<4;i++){
                int direction=(this.direction+3-i)%4;
                int nx=x+dx[direction];
                int ny=y+dy[direction];
                if(nx>=0&&nx<N&&ny>=0&&ny<M&&map[nx][ny]==0){
                    flag = true;
                    this.x=nx;
                    this.y=ny;
                    this.direction=direction;
                    break;
                }
            }
            return flag;
        }

        public boolean back(){
            if(map[x -dx[direction]][y - dy[direction]] != 1)
            {
                this.x=x-dx[direction];
                this.y=y-dy[direction];
                return true;
            }
            return false;
        }

    }
    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);

        input=br.readLine().split(" ");
        Robot robot=new Robot(Integer.parseInt(input[0]),Integer.parseInt(input[1]),Integer.parseInt(input[2]));

        map=new int[N][M];
        for(int i=0;i<N;i++){
            input=br.readLine().split(" ");
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(input[j]);
            }
        }

        while(true){
            robot.cleaning();
            if(!robot.move()){

                if(!robot.back())
                    break;
            }

        }
        bw.write(String.valueOf(robot.cnt));
        bw.flush();
        bw.close();
        br.close();
    }


}