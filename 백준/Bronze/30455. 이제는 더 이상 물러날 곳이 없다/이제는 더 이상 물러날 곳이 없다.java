import java.io.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        br.close();
        if(N%2==0){
            bw.write("Duck");
        }
        else{
            bw.write("Goose");
        }
        bw.flush();
        bw.close();
    }
}