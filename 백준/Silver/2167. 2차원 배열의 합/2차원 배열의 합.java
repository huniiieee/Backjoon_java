import java.io.*;

public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int M;
    public static int K;

    public static void main(String[] args) throws IOException {
        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);
        int[][]array=new int[N][M];
        for (int i = 0; i < N; i++) {
            input=br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                array[i][j]=Integer.parseInt(input[j]);
            }
        }
        K=Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            input=br.readLine().split(" ");
            int sr=Integer.parseInt(input[0])-1;
            int sc=Integer.parseInt(input[1])-1;
            int er=Integer.parseInt(input[2])-1;
            int ec=Integer.parseInt(input[3])-1;
            bw.write(sum(array,sr,er,sc,ec)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int sum(int [][]array,int sr,int er,int sc,int ec){
        int result=0;
        for (int i = sr; i <=er ; i++) {
            for (int j = sc; j <=ec ; j++) {
                result +=array[i][j];
            }
        }
        return result;
    }
}