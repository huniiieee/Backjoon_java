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
        int [] dot=new int[N];
        input=br.readLine().split(" ");
        for(int i=0;i<N;i++){
            dot[i]=Integer.parseInt(input[i]);
        }
        Arrays.sort(dot);
        for (int i = 0; i < M; i++) {
            input=br.readLine().split(" ");
            int start=Integer.parseInt(input[0]);
            int end=Integer.parseInt(input[1]);
            int result=rightIndex(dot,end)-leftIndex(dot,start);
            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();
    }

    public static int leftIndex(int []dot,int start){
        int left=0;
        int right=N-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(dot[mid]>=start){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }

    public static int rightIndex(int []dot,int end){
        int left=0;
        int right=N-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(dot[mid]<=end){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return left;
    }
}