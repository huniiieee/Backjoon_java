import java.io.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static long N;

    public static void main(String[] args) throws IOException {
        N=Long.parseLong(br.readLine());
        br.close();
        if(N%5==0||N%5==2){
            bw.write("CY");
        }
        else{
            bw.write("SK");
        }
        bw.flush();
        bw.close();
    }
}