import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int X;

    public static void main(String[] args) throws IOException {
        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        X=Integer.parseInt(input[1]);
        int [] limit=new int[N];
        input=br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            limit[i]=Integer.parseInt(input[i]);
        }
        int turn=0;
        while(true){
            if(limit[turn]<X){
                bw.write(String.valueOf(turn+1));
                break;
            }
            X++;
            turn= (turn+1)%N;
        }
        bw.flush();
        bw.close();
    }




}