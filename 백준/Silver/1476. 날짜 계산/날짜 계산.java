
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int E;
    public static int S;
    public static int M;

    public static void main(String[] args) throws IOException {

        String [] input =br.readLine().split(" ");
        E=Integer.parseInt(input[0]);
        S=Integer.parseInt(input[1]);
        M=Integer.parseInt(input[2]);
        int result=0;
        for (int i = 0; result==0; i++) {
            int temp=15*i+E;
            for (int j = 0; result==0; j++) {
                if(28*j+S>temp){
                    break;
                }
                if(28*j+S==temp){
                    for (int k = 0; ; k++) {
                        if(19*k+M>temp){
                            break;
                        }
                        if(19*k+M==temp){
                            result=temp;
                            break;
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }


}
