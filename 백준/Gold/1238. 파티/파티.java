import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int M;
    public static int X;



    static class Node implements Comparable<Node>{
        int node,time;

        public Node(int node,int time){
            this.node=node;
            this.time=time;
        }

        @Override
        public int compareTo(Node o){
            return this.time-o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);
        X=Integer.parseInt(input[2]);
        List<List<Node>> road=new ArrayList<>();
        List<List<Node>> reverseRoad=new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            road.add(new ArrayList<>());
            reverseRoad.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            input=br.readLine().split(" ");
            int start=Integer.parseInt(input[0]);
            int end=Integer.parseInt(input[1]);
            int time=Integer.parseInt(input[2]);
            road.get(start).add(new Node(end,time));
            reverseRoad.get(end).add(new Node(start,time));
        }

        int []dist=new int[N+1];
        int []reverseDist=new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(reverseDist,Integer.MAX_VALUE);
        dijkstra(road,dist);
        dijkstra(reverseRoad,reverseDist);
        int result=0;
        for (int i = 1; i <=N ; i++) {
            result=Integer.max(result,dist[i]+reverseDist[i]);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static void dijkstra(List<List<Node>>road,int[]dist){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        dist[X]=0;
        pq.add(new Node(X,0));
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            for(Node next:road.get(cur.node)){
                if(dist[next.node]>dist[cur.node]+next.time){
                    dist[next.node]=dist[cur.node]+next.time;
                    pq.add(new Node(next.node,dist[next.node]));
                }
            }
        }
    }





}