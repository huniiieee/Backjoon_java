
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int A;
    public static int B;
    public static int C;
    public static int D;

    public static void main(String[] args) throws IOException {

        String [] input =br.readLine().split(" ");
        A=Integer.parseInt(input[0]);
        B=Integer.parseInt(input[1]);
        input =br.readLine().split(" ");
        C=Integer.parseInt(input[0]);
        D=Integer.parseInt(input[1]);
        int divisor=B*D;
        int divided=A*D+B*C;

        for (int i = divisor; i>1; i--) {
            if(divisor%i==0&&divided%i==0){
                divisor /=i;
                divided /=i;
                break;
            }
        }
        bw.write(divided+" "+divisor);
        bw.flush();
        bw.close();
    }


}
