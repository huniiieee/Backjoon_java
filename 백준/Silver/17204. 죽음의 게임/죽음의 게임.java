import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int K;

    public static void main(String[] args) throws IOException {
        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        K=Integer.parseInt(input[1]);

        int [] points=new int[N];
        for (int i = 0; i < N; i++) {
            points[i]=Integer.parseInt(br.readLine());
        }
        boolean []visited=new boolean[N];

        int result=1;
        int next=0;
        while(true){
            next=points[next];
            if(next==K) break;

            if(visited[next]){
                result=-1;
                break;
            }
            else{
                result++;
                visited[next]=true;
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }


}
