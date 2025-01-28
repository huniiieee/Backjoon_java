
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static long T;
    public static int N;
    public static int M;


    public static void main(String[] args) throws IOException {

        T=Integer.parseInt(br.readLine());
        N=Integer.parseInt(br.readLine());
        List<Long> sumA=new ArrayList<>();
        List<Long> sumB=new ArrayList<>();
        String [] input =br.readLine().split(" ");
        int [] A=new int[N];
        for (int i = 0; i < N; i++) {
            A[i]=Integer.parseInt(input[i]);
            sumA.add((long)A[i]);
        }
        M=Integer.parseInt(br.readLine());
        int [] B=new int[M];
        input =br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            B[i]=Integer.parseInt(input[i]);
            sumB.add((long)B[i]);
        }

        for (int i = 0; i < N-1; i++) {
            int temp=A[i];
            for (int j = i+1; j < N; j++) {
                temp +=A[j];
                sumA.add((long)temp);
            }
        }

        for (int i = 0; i < M-1; i++) {
            int temp=B[i];
            for (int j = i+1; j < M; j++) {
                temp +=B[j];
                sumB.add((long)temp);
            }
        }

        Collections.sort(sumA);
        Collections.sort(sumB);
        long result=0;
        for (int i = 0; i < sumA.size();) {
            long cur=sumA.get(i);
            long cntA=upper(sumA,cur)-lower(sumA,cur);
            long cntB=upper(sumB,T-cur)-lower(sumB,T-cur);
            result +=cntA*cntB;
            i+=cntA;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static int lower(List<Long> sumB,long remain){
        int left=0,right=sumB.size()-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(sumB.get(mid)>=remain){
                right =mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }

    public static int upper(List<Long> sumB,long remain){
        int left=0,right=sumB.size()-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(sumB.get(mid)>remain){
                right =mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }

}
