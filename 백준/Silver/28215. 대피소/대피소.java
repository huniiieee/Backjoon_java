import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int K;
    public static int result=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        K=Integer.parseInt(input[1]);

        int [][]houses=new int[N][2];
        for (int i = 0; i < N; i++) {
            input=br.readLine().split(" ");
            int x=Integer.parseInt(input[0]);
            int y=Integer.parseInt(input[1]);

            houses[i][0]=x;
            houses[i][1]=y;
        }
        List<Integer> shelters=new LinkedList<>();
        backtrack(houses,0,shelters,-1);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }


    public static void backtrack(int [][]houses,int cnt,List<Integer> shelters,int preIdx){
        if(cnt==K){
            result=Integer.min(result,check(houses,shelters));
            return;
        }

        for (int i = preIdx+1; i < N; i++) {
            shelters.add(i);
            backtrack(houses,cnt+1,shelters,i);
            shelters.remove(cnt);
        }
    }

    public static int check(int[][]houses,List<Integer> shelters){
        int max=0;
        for (int i = 0; i < N; i++) {
            int min=Integer.MAX_VALUE;
            for (int j = 0; j < K; j++) {
                int idx=shelters.get(j);
                int distance= Math.abs(houses[i][0]-houses[idx][0])+Math.abs(houses[i][1]-houses[idx][1]);
                min=Integer.min(min,distance);
            }
            max=Integer.max(max,min);
        }
        return max;
    }
}
