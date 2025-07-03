import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);

        if(N==0){
            System.out.println(0);
            return;
        }

        input=br.readLine().split(" ");
        int []books=new int[N];
        for(int i=0;i<N;i++){
            books[i]=Integer.parseInt(input[i]);
        }

        int cnt=1;
        int w=0;
        for (int i = 0; i < N; i++) {
            int book=books[i];
            w +=book;
            if(w>M){
                cnt++;
                w=book;
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }





}
