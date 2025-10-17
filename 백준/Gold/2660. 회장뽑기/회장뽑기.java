import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        int [][]floyd=new int[N+1][N+1];
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                floyd[i][j]=50;
            }
        }

        while(true){
            String []input=br.readLine().split(" ");
            if(input[0].equals("-1")) break;

            int a=Integer.parseInt(input[0]);
            int b=Integer.parseInt(input[1]);
            floyd[a][b]=1;
            floyd[b][a]=1;
        }

        for (int k = 1; k < N+1; k++) {
            for (int i = 1; i < N+1; i++) {
                for (int j = 1; j < N+1; j++) {
                    if(i==j) {
                        floyd[i][j]=0;
                        continue;
                    }
                    floyd[i][j]=Math.min(floyd[i][j],floyd[i][k]+floyd[k][j]);
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        int cnt=1;
        int result=50;
        for (int i = 1; i < N+1; i++) {
            int max=0;
            for (int j = 1; j < N+1; j++) {
                if(i==j) continue;
                max=Math.max(max, floyd[i][j]);
            }
            if(max<result){
                sb=new StringBuilder();
                sb.append(i).append(" ");
                cnt=1;
                result=max;
            }
            else if(max==result){
                sb.append(i).append(" ");
                cnt++;
            }
        }
        System.out.println(result+" "+cnt);
        System.out.println(sb.toString());
    }

}
