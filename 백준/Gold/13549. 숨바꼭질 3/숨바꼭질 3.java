import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int K;
    public static int max=100000;

    public static void main(String[] args) throws IOException {
        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        K=Integer.parseInt(input[1]);
        Queue<int []> q=new LinkedList<>();
        q.add(new int[]{N,0});
        int result=0;
        boolean []visited=new boolean[100001];
        while(!q.isEmpty()){
            int []cur=q.poll();
            int n=cur[0];
            int cnt=cur[1];
            if(n==K){
                result=cnt;
                break;
            }
            int jump=n*2;
            int front=n+1;
            int back=n-1;
            if(jump<=max && jump<2*K &&!visited[jump]){
                q.offer(new int[]{jump,cnt});
                visited[jump]=true;
            }
            if(back>=0&&!visited[back]){
                q.offer(new int[]{back,cnt+1});
                visited[back]=true;
            }
            if(front<=max&&!visited[front]){
                q.offer(new int[]{front,cnt+1});
                visited[front]=true;
            }

        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}