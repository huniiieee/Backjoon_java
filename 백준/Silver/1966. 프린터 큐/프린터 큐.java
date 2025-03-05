import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int CASE;
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        CASE=Integer.parseInt(br.readLine());
        for(int i=0;i<CASE;i++){
            String []input=br.readLine().split(" ");
            N=Integer.parseInt(input[0]);
            M=Integer.parseInt(input[1]);
            int [] printer=new int[N];
            input=br.readLine().split(" ");

            Queue<int []> queue=new LinkedList<>();
            for(int j=0;j<N;j++){
                printer[j]=Integer.parseInt(input[j]);
                queue.add(new int[]{j,printer[j]});
            }

            Arrays.sort(printer);

            int maxIndex=N-1;
            int result=1;
            while(!queue.isEmpty()){
                int[] cur=queue.poll();
                int index=cur[0];
                int value=cur[1];
                if(value<printer[maxIndex]){
                    queue.add(new int[]{index,value});
                    continue;
                }
                if(M==index){
                    bw.write(result+"\n");
                    break;
                }
                maxIndex--;
                result++;
            }
        }
        bw.close();
    }




}