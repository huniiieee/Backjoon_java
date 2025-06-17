import java.io.*;


public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;

    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        String []input=br.readLine().split(" ");
        int []numbers=new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i]=Integer.parseInt(input[i]);
        }
        boolean []visited=new boolean[100001];

        int right=0;
        long result=0;

        for (int left = 0; left < N; left++) {
            while(right<N){
                if(visited[numbers[right]]) break;
                visited[numbers[right]]=true;
                right++;
            }
            result +=(right-left);
            visited[numbers[left]]=false;

        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }


}
