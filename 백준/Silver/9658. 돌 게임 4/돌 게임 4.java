import java.io.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        br.close();
        if(N%7==1 || N%7==3){
            bw.write("CY");
        }
        else{
            bw.write("SK");
        }
        bw.flush();
        bw.close();
    }
}