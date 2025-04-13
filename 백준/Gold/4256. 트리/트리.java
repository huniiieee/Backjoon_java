import java.io.*;
import java.util.*;
public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int T;
    public static int N;
    public static int[] pre;
    public static int[]in;
    public static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            N=Integer.parseInt(br.readLine());
            pre=new int[N];
            in=new int[N];
            String []input=br.readLine().split(" ");
            for(int j=0;j<N;j++){
                pre[j]=Integer.parseInt(input[j]);
            }
            input=br.readLine().split(" ");
            for(int j=0;j<N;j++){
                in[j]=Integer.parseInt(input[j]);
            }
            post(0,0,N);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void post(int root,int start,int end){
        if(root>=N){
            return;
        }
        int rootValue=pre[root];
        for(int i=start;i<end;i++){
            if(in[i]==rootValue){
                post(root+1,start,i);
                post(root+(i-start)+1,i+1,end);
                sb.append(rootValue).append(" ");
            }
        }
    }

}