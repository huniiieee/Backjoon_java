import java.util.*;

class Solution {
    List<List<Integer>> list=new ArrayList<>();
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int len=sources.length;
        int[] answer = new int[len];
        int[] dist = new int[n + 1];  
        Arrays.fill(dist, -1);
        
        for(int i=0;i<=n;i++){
            list.add(new LinkedList<>());
        }
        
        int roadLen= roads.length;
        for(int i=0;i<roadLen;i++){
            int road1=roads[i][0];
            int road2=roads[i][1];
            list.get(road1).add(road2);
            list.get(road2).add(road1);
        }
        bfs(destination,n,dist);
        for(int i=0;i<len;i++){
            answer[i]=dist[sources[i]];
        }
        
        return answer;
    }
    
    public void bfs(int start,int n,int []dist){
        Queue<Integer> q=new LinkedList<>();
        boolean []visited=new boolean[n+1];
        visited[start]=true;
        q.offer(start);
        dist[start]=0;
        while(!q.isEmpty()){
            int road=q.poll();
            
            for(int next:list.get(road)){
                if(!visited[next]){
                    visited[next]=true;
                    q.offer(next);
                    dist[next]=dist[road]+1;
                }
            }
        }
    }
    
}