import java.util.*;

class Solution {
    List<List<Node>> graph=new ArrayList<>();
    class Node implements Comparable<Node>{
        public int next;
        public int cost;
        
        public Node(int next,int cost){
            this.next=next;
            this.cost=cost;
        }
        
        @Override
        public int compareTo(Node e){
            return this.cost-e.cost;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<road.length;i++){
            int node1=road[i][0];
            int node2=road[i][1];
            int cost=road[i][2];
            graph.get(node1).add(new Node(node2,cost));
            graph.get(node2).add(new Node(node1,cost));
        }
        int [] cost=new int[N+1];
        for(int i=1;i<N+1;i++)
            cost[i]=Integer.MAX_VALUE;
        
        dijkstra(cost,1);
        for(int i=1;i<N+1;i++){
            answer += (cost[i]<=K ? 1 : 0);
        }
        return answer;
    }
    
    public void dijkstra(int[] cost, int start) {
        cost[start] = 0;
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cost[cur.next] < cur.cost) continue;

            for (Node e : graph.get(cur.next)) {
                if (cost[e.next] > cur.cost + e.cost) {
                    cost[e.next] = cur.cost + e.cost;
                    pq.offer(new Node(e.next, cost[e.next]));
                }
            }
        }
    }

}