import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;


    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->Math.abs(o1)==Math.abs(o2)?o1.compareTo(o2):Math.abs(o1)-Math.abs(o2));
        for (int i = 0; i < N; i++) {
            int x=Integer.parseInt(br.readLine());
            if(x!=0){
                pq.offer(x);
                continue;
            }
            int output= pq.isEmpty()?0:pq.poll();
            bw.write(output+"\n");
        }
        bw.flush();
        bw.close();
    }



}