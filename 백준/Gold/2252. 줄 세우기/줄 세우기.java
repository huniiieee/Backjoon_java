import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    public static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N=Integer.parseInt(input.split(" ")[0]);
        M=Integer.parseInt(input.split(" ")[1]);

        List<List<Integer>> graph = new ArrayList<>();
        int [] indegree = new int[N+1];

        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            String []temp=br.readLine().split(" ");
            int a=Integer.parseInt(temp[0]);
            int b=Integer.parseInt(temp[1]);
            graph.get(a).add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<N+1;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int now=q.poll();
            sb.append(now).append(" ");

            for(Integer next:graph.get(now)){
                indegree[next]--;
                if(indegree[next]==0){
                    q.add(next);
                }
            }
        }
        System.out.println(sb.toString());
    }


}
