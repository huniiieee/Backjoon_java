import java.io.*;

public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int R;
    public static int C;
    public static int N;

    public static void main(String[] args) throws IOException {
        String []input=br.readLine().split(" ");
        R=Integer.parseInt(input[0]);
        C=Integer.parseInt(input[1]);
        N=Integer.parseInt(br.readLine());
        int []stores=new int[N+1];
        for(int i=0;i<=N;i++){
            input=br.readLine().split(" ");
            int tempX=Integer.parseInt(input[0]);
            int tempY=Integer.parseInt(input[1]);
            if(tempX==1){
                stores[i]=tempY;
            }
            else if(tempX==4){
                stores[i]=R+tempY;
            }
            else if(tempX==3){
                stores[i]=0-tempY;
            }
            else{
                stores[i]=0-C-tempY;
            }
        }
        int result=0;
        int len=2*(R+C);
        for(int i=0;i<N;i++){
            int diff=Math.abs(stores[N]-stores[i]);
            result +=Integer.min(diff,len-diff);
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }


}