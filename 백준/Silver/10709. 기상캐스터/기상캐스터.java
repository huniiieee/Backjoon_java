import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int H;
    public static int W;


    public static void main(String[] args) throws IOException {
        String []input=br.readLine().split(" ");
        H=Integer.parseInt(input[0]);
        W=Integer.parseInt(input[1]);

        int [][]result=new int[H][W];

        for (int i = 0; i < H; i++) {
            String row = br.readLine();
            int cloud=-1;
            boolean flag=false;
            for (int j = 0; j < W; j++) {
                boolean isCloud = (row.charAt(j) == 'c');
                if(isCloud){
                    flag=true;
                    cloud=-1;
                }
                if(flag) cloud++;

                result[i][j]=cloud;
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                bw.write(result[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
}
