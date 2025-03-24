import java.io.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int E;
    public static int S;
    public static int M;


    public static void main(String[] args) throws IOException {

        String [] input= br.readLine().split(" ");

        E=Integer.parseInt(input[0]);
        S=Integer.parseInt(input[1]);
        M=Integer.parseInt(input[2]);

        int rangeE=15;
        int rangeS=28;  //제일 값이 크기 때문에 기준으로 사용
        int rangeM=19;

        for (int i = 0; ; i++) {
            int checkS=i*28+S;
            int checkE=(checkS%rangeE)==0 ? rangeE:checkS%rangeE;
            int checkM=(checkS%rangeM)==0 ? rangeM:checkS%rangeM;


            if(checkE==E && checkM==M){
                bw.write(String.valueOf(checkS));
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}