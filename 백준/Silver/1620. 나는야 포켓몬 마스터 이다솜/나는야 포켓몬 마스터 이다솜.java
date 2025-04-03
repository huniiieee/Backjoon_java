import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int M;



    public static void main(String[] args) throws IOException {
        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);
        Map<Integer,String> number=new HashMap<>();
        Map<String,Integer> string=new HashMap<>();
        for(int i=0;i<N;i++) {
            String temp=br.readLine();
            number.put(i+1,temp);
            string.put(temp,i+1);
        }
        for (int i = 0; i < M; i++) {
            String temp=br.readLine();
            if(temp.charAt(0)>='0'&&temp.charAt(0)<='9') {
                bw.write(number.get(Integer.parseInt(temp))+"\n");
            }
            else{
                bw.write(string.get(temp)+"\n");
            }
        }

        bw.flush();
        bw.close();
    }
}