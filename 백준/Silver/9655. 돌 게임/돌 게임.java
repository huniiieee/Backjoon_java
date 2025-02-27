import java.io.*;

public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        br.close();
        while(N>=4){
            N -=4;
        }
        if(N==0||N==2){
            bw.write("CY");
        }
        else{
            bw.write("SK");
        }
        bw.flush();
        bw.close();
    }
}