import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int []dx={-1,0,1,0};
    public static int []dy={0,-1,0,1};

    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        String input=br.readLine();
        char [][]miro=new char[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                miro[i][j]='#';
            }
        }
        int minX=50; int maxX=50;
        int minY=50; int maxY=50;
        int x=50; int y=50;
        int dir=2;
        miro[x][y]='.';

        for (int i = 0; i < N; i++) {
            char move=input.charAt(i);
            if(move=='F') {
                x +=dx[dir];
                y +=dy[dir];
                miro[x][y]='.';
                minX=Integer.min(minX,x);
                maxX=Integer.max(maxX,x);
                minY=Integer.min(minY,y);
                maxY=Integer.max(maxY,y);
            }
            else if(move=='R') dir = (dir+3)%4;
            else if(move=='L') dir=(dir+1)%4;

        }
        for (int i = minX; i <=maxX ; i++) {
            for (int j = minY; j <=maxY ; j++) {
                bw.write(String.valueOf(miro[i][j]));
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
