import java.io.*;

public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;

    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        int [] lines=new int[N];
        String[]input=br.readLine().split(" ");
        for (int i = 0; i <N ; i++) {
            lines[i]=Integer.parseInt(input[i]);
        }
        boolean [] visited=new boolean[N];
        int []result=new int[N];
        for (int i = 0; i < N; i++) {
            int idx=lines[i];
            int start=0;
            while(idx>=0){
                if(visited[start]){
                    start++;
                    continue;
                }
                idx --;
                start++;
            }
            visited[start-1]=true;
            result[start-1]=i+1;
        }
        for (int i = 0; i <N ; i++) {
            bw.write(result[i]+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }


}