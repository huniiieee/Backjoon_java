import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static String S;



    public static void main(String[] args) throws IOException {

        S=br.readLine();
        int [] count=new int[2];
        count[Character.getNumericValue(S.charAt(0))]++;
        for (int i = 1; i <S.length() ; i++) {
            if(S.charAt(i)!=S.charAt(i-1)){
                count[Character.getNumericValue(S.charAt(i))]++;
            }
        }
        bw.write(String.valueOf(Integer.min(count[0],count[1])));
        bw.flush();
        bw.close();
    }
}
