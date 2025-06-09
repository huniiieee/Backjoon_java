import java.io.*;

public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int R;
    public static int C;
    public static int K;
    public static int result=0;

    public static int [] dx={-1,0,1,0};
    public static int [] dy={0,1,0,-1};
    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        R=Integer.parseInt(input[0]);
        C=Integer.parseInt(input[1]);
        K=Integer.parseInt(input[2]);
        char [][]map=new char[R][C];
        for (int i = 0; i < R; i++) {
            String temp=br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j]=temp.charAt(j);
            }
        }
        boolean [][]visited=new boolean[R][C];
        visited[R-1][0]=true;
        dfs(map,visited,R-1,0,1);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(char [][]map,boolean[][]visited,int r,int c,int cnt){
        if(cnt==K){
            if(r==0&&c==C-1){
                result++;
            }
            return;
        }
        for(int i=0;i<4;i++){
            int nr=r+dx[i];
            int nc=c+dy[i];
            if(nr>=0&&nr<R&&nc>=0&&nc<C&&!visited[nr][nc]&&map[nr][nc]!='T'){
                visited[nr][nc]= true;
                dfs(map,visited,nr,nc,cnt+1);
                visited[nr][nc]=false;
            }
        }

    }


}