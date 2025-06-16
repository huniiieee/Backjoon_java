import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static String S;

    public static void main(String[] args) throws IOException {

        S=br.readLine();
        int len=S.length();
        int result=0;
        for (int i = 0; i < len; i++) {
            String temp=S.substring(i);
            String reversed = new StringBuilder(temp).reverse().toString();
            if(temp.equals(reversed)){
                result=i*2+temp.length();
                break;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }


}
