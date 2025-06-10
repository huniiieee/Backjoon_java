import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int S;
    public static int cnt=1;

    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        int []stones=new int[N+1];
        String []input=br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            stones[i]=Integer.parseInt(input[i-1]);
        }
        int S=Integer.parseInt(br.readLine());

        boolean []visited=new boolean[N+1];
        visited[S]=true;
        Queue<Integer> queue =new LinkedList<>();
        queue.offer(S);
        while(!queue.isEmpty()){
            int cur=queue.poll();
            int nl=cur-stones[cur];
            int nr=cur+stones[cur];
            if(nl>=1&&!visited[nl]){
                visited[nl]=true;
                queue.offer(nl);
                cnt++;
            }
            if(nr<=N&&!visited[nr]){
                visited[nr]=true;
                queue.offer(nr);
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }


}