import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int R;
    public static int C;
    public static char[][]map;
    public static int x;    //지훈 x좌표
    public static int y;    //지훈 y좌표
    public static Queue<int []> fire= new LinkedList<>();
    public static int[]dx={-1,0,1,0};
    public static int[]dy={0,1,0,-1};


    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        R=Integer.parseInt(input[0]);
        C=Integer.parseInt(input[1]);
        map=new char[R][C];
        for (int i = 0; i < R; i++) {
            String temp=br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j]=temp.charAt(j);
                if(map[i][j]=='J'){
                    x=i;
                    y=j;
                }
                if(map[i][j]=='F'){
                    fire.add(new int[]{i,j});
                }
            }
        }
        int result=answer();
        if(result==0){
            bw.write("IMPOSSIBLE");
        }
        else{
            bw.write(String.valueOf(result));
        }

        bw.flush();
        bw.close();
    }

    public static void fireMove() {
        int size=fire.size();
        for (int i = 0; i < size; i++) {
            int []cur=fire.poll();
            int x=cur[0];
            int y=cur[1];
            for (int j = 0; j < 4; j++) {
                int nx=x+dx[j];
                int ny=y+dy[j];
                if(nx>=0 && ny>=0 && nx<R && ny<C &&(map[nx][ny]!='#')&&(map[nx][ny]!='F')){
                    fire.add(new int[]{nx,ny});
                    map[nx][ny]='F';
                }
            }
        }
    }

    public static int answer(){
        int temp=0;     // 불이 이동해야 할 때를 알려주는 변수 (너비 우선 탐색의 너비가 다음으로 증가할 때 불 이동 한번)
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x,y,0});
        while(!queue.isEmpty()){
            int []cur=queue.poll();
            int x=cur[0];
            int y=cur[1];
            int cnt=cur[2];
            if(x==0||y==0||x==R-1||y==C-1){
                return cnt+1;
            }
            if(cnt==temp){
                fireMove();
                temp++;
            }
            for (int i = 0; i < 4; i++) {
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=0&&ny>=0&&nx<R&&ny<C&&map[nx][ny]=='.'){
                    map[nx][ny]='J';
                    queue.add(new int[]{nx,ny,cnt+1});
                }
            }
        }
        return 0;
    }
}