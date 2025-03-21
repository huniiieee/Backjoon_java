import java.io.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int M;
    public static int result=1;


    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);
        int [][]map=new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp=br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j]=Character.getNumericValue(temp.charAt(j));
            }
        }
        int max=Integer.min(N,M);

        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < M-1; j++) {
                for (int k = max; k > 1; k--) {
                    int add=k-1;  //k가 변의 길이이므로 오른쪽, 아래로 k-1만큼 더해서 확인
                    if(i+add<N&&j+add<M&&map[i+add][j+add]==map[i][j]&&map[i][j+add]==map[i][j]&&map[i+add][j]==map[i][j]){
                        result=Integer.max(result,k*k);
                        break;
                    }
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}