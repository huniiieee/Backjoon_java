import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static class Node{
        int next;
        int dis;

        public Node(int next,int dis){
            this.next=next;
            this.dis=dis;
        }
    }
    static List<List<Node>> graph=new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N=Integer.parseInt(input.split(" ")[0]);
        M=Integer.parseInt(input.split(" ")[1]);

        for (int i = 0; i <= N; i++) {
            graph.add(new LinkedList<>());
        }

        for(int i=0;i<N-1;i++){
            String []temp=br.readLine().split(" ");
            int start=Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            int dis = Integer.parseInt(temp[2]);
            graph.get(start).add(new Node(end,dis));
            graph.get(end).add(new Node(start,dis));
        }

        for (int i = 0; i < M; i++) {
            String []temp= br.readLine().split(" ");
            System.out.println(bfs(Integer.parseInt(temp[0]),Integer.parseInt(temp[1])));
        }

    }

    static int bfs(int node1,int node2){
        Queue<int []> q=new LinkedList<>();
        boolean []visited=new boolean[N+1];

        int result=0;
        q.offer(new int[]{node1,0});
        visited[node1]=true;

        while(!q.isEmpty()){
            int[] cur=q.poll();
            int node =cur[0];
            int cnt=cur[1];

            if(node==node2){
                result=cnt;
                break;
            }

            for(Node n:graph.get(node)){
                int nextNode=n.next;
                int dis=n.dis;

                if(visited[nextNode]) continue;
                visited[nextNode]=true;
                q.offer(new int[]{nextNode,cnt+dis});
            }
        }
        return result;
    }

}
