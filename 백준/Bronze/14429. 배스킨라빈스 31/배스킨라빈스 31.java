import java.io.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int J;
    public static int M;

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        int min=Integer.MAX_VALUE;   //result
        int minIndex=0;  //result Index
        for (int i = 0; i < N; i++) {
            String [] input=br.readLine().split(" ");
            J=Integer.parseInt(input[0]);
            M=Integer.parseInt(input[1]);
            int start=(J-1)%(M+1);  //start
            int temp=((J-start)/(M+1)+1)*2; //count
            if(temp<min){
                min=temp;
                minIndex=i+1;
            }
        }
        bw.write(minIndex+" "+min);
        bw.flush();
        bw.close();
    }
}