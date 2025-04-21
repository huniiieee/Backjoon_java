import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;

    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        int []numbers=new int[N];
        String[]input=br.readLine().split(" ");
        for (int i = 0; i <N ; i++) {
            numbers[i]=Integer.parseInt(input[i]);
        }
        boolean []visited=new boolean[N];
        visited[0]=true;
        bw.write(1+" ");
        int cur=0;
        int cnt=N;
        while(--cnt >0){
            int number=numbers[cur];
            int next=number>0 ? 1:-1;
            int plus=number>0 ? 0:N;
            number=Math.abs(number);
            while(number>0){
                cur=(cur+next+plus)%N;
                if(!visited[cur]){
                    number--;
                }
            }
            visited[cur]=true;
            bw.write(cur+1+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }


}