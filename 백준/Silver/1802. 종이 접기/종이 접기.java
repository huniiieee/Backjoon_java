
import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;

    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String input=br.readLine();
            if(check(input)){
                bw.write("YES\n");
            }
            else{
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static boolean check(String paper){
        if(paper.length()==1){
            return true;
        }

        int len=paper.length();
        int newLen=(len-1)/2;
        for (int i = 0; i < newLen; i++) {
            if(paper.charAt(i)==paper.charAt(len-1-i))
                return false;
        }
        return check(paper.substring(0,newLen)) && check(paper.substring(newLen+1));


    }



}
