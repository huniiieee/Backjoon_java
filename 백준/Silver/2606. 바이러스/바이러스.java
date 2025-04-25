
import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int M;



    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());
        List<List<Integer>> networks=new ArrayList<>();
        for(int i=0;i<=N;i++) networks.add(new ArrayList<>());

        for(int i=0;i<M;i++){
            String []input=br.readLine().split(" ");
            int x1=Integer.parseInt(input[0]);
            int x2=Integer.parseInt(input[1]);
            networks.get(x1).add(x2);
            networks.get(x2).add(x1);
        }

        int result=-1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean []visited =new boolean[N+1];
        visited[1]=true;
        while(!queue.isEmpty()){
            int cur=queue.poll();
            result++;
            for(Integer next:networks.get(cur)){
                if(!visited[next]){
                    queue.offer(next);
                    visited[next]=true;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }


}