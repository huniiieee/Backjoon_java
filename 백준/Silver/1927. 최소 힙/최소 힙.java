import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            int x=Integer.parseInt(br.readLine());
            if(x==0){
                if(priorityQueue.isEmpty()){
                    bw.write(0+"\n");
                }
                else{
                    bw.write(priorityQueue.poll()+"\n");
                }
            }
            else{
                priorityQueue.offer(x);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }


}