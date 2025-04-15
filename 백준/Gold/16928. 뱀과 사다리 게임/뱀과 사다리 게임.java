import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int M;




    public static void main(String[] args) throws IOException {
        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<N+M;i++){
            input=br.readLine().split(" ");
            map.put(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }
        Queue<int []> queue = new LinkedList<>();
        boolean []visited=new boolean[101];
        queue.offer(new int[]{1,0});
        visited[1]=true;
        while(!queue.isEmpty()){
            int []cur= queue.poll();
            int place=cur[0];
            int cnt=cur[1];
            if(place==100){
                bw.write(String.valueOf(cnt));
                break;
            }
            for(int i=1;i<=6;i++){
                int next=place+i;
                if(next>100)
                    break;
                if(map.containsKey(next)){
                   next=map.get(next);
                }

                if(!visited[next]){
                    queue.offer(new int[]{next,cnt+1});
                    visited[next]=true;
                }
            }

        }
        bw.flush();
        bw.close();
    }


}