import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int M;

    public static int[] dx ={1,0,-1,0};
    public static int[] dy ={0,1,0,-1};


    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        M=Integer.parseInt(input[0]);
        N=Integer.parseInt(input[1]);

        int x=0; int y=0;
        int dir=0;
        boolean flag=false;
        for (int i = 0; i <N ; i++) {
            input=br.readLine().split(" ");
            String command=input[0];
            int distance=Integer.parseInt(input[1]);
            if(command.equals("TURN")){
                if(distance==0) dir= (dir+1)%4;
                else dir=(dir+3)%4;
                continue;
            }

            x=x+dx[dir]*distance;
            y=y+dy[dir]*distance;
            if(x<0||x>=M||y<0||y>=M){
                flag=true;
                break;
            }
        }
        if(flag) bw.write(-1+"");
        else bw.write(x+" "+y);

        bw.flush();
        bw.close();
        br.close();
    }
}