import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N=0;
    public static int M=0;


    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());
        bw.write(String.valueOf(multiChoose(M-N,N)));
        bw.flush();
        bw.close();
    }

    public static int multiChoose(int n,int m){
        int space=n+m-1;
        int bar=m-1;
        return combination(space,bar);
    }
    public static int combination(int n, int m) {
        if (m > n - m) m = n - m;  // nCm == nC(n-m), 더 작은 쪽 선택
        int result = 1;
        for (int i = 0; i < m; i++) {
            result = result * (n - i) / (i + 1);
        }
        return result;
    }
}