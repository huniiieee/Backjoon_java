import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int R;
    public static int C;

    public static int[]dr={-1,0,1,0};
    public static int[]dc={0,1,0,-1};

    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        R=Integer.parseInt(input[0]);
        C=Integer.parseInt(input[1]);

        char [][]map=new char[R][C];
        for (int i = 0; i < R; i++) {
            String temp=br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j]=temp.charAt(j);
            }
        }

        fifty(map);
        int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE, maxR = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j]=='X'){
                    minR = Integer.min(i,minR);
                    minC=Integer.min(j,minC);
                    maxR = Integer.max(i,maxR);
                    maxC=Integer.max(j,maxC);
                }
            }
        }

        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <=maxC; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void fifty(char [][]map){
        boolean [][]visited=new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j]=='X'){
                    int cnt=0;
                    for (int k = 0; k < 4; k++) {
                        int nr=i+dr[k];
                        int nc=j+dc[k];
                        if(nr>=0&&nr<R&&nc>=0&&nc<C&&map[nr][nc]=='.') cnt++;
                        if(nr<0||nr>=R||nc<0||nc>=C) cnt++;
                    }
                    if(cnt>=3) visited[i][j]=true;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(visited[i][j]) map[i][j]='.';
            }
        }
    }

}
