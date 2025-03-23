import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static int T=0;

    public static void main(String[] args) throws IOException {
        T=Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N=Integer.parseInt(br.readLine());
            bw.write(result(N)+"\n");
        }
        bw.flush();
        bw.close();
    }
    

    static int result(int N){
        int temp=0;
        //i는 3의 개수
        for (int i = 0; i <= N/3; i++) {
            int left=N-3*i;
            temp +=(left/2+1);  //2를 사용할 수 있는 개수 (0포함)
        }
        return temp;
    }

}