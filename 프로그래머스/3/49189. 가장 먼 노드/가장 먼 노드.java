import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    
    static int max=Integer.MIN_VALUE;
    static int answer=0;
    public int solution(int n, int[][] edge) {
        
        List<List<Integer>> node=new LinkedList<>();
        for(int i=0;i<=n;i++) node.add(new LinkedList<>());
        
        int edgeLen=edge.length;
        for(int i=0;i<edgeLen;i++){
            int node1=edge[i][0];
            int node2=edge[i][1];
            
            node.get(node1).add(node2);
            node.get(node2).add(node1);
        }
        
        int []distance = new int[n+1];
        distance[1]=0;
        for(int i=2;i<=n;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        dijkstra(node,distance);
        
        return answer;
    }
    
    public void dijkstra(List<List<Integer>> node, int []distance){
        Queue<Integer> queue = new LinkedList<>(); 
        queue.add(1);
        while(!queue.isEmpty()){
            int cur=queue.poll();
            for(Integer n:node.get(cur)){
                if(distance[n]!=Integer.MAX_VALUE) continue;
                distance[n]=distance[cur]+1;
                queue.add(n);
                if(distance[n]>max){
                    max=distance[n];
                    answer=1;
                }
                else if(distance[n]==max){
                    answer +=1;
                }
            }
        }
    }
}