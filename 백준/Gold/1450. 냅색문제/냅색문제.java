

import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int C;

    public static void main(String[] args) throws IOException {

        String [] input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        C=Integer.parseInt(input[1]);

        input=br.readLine().split(" ");
        int []weight=new int[N];
        for (int i = 0; i < N; i++) {
            weight[i]=Integer.parseInt(input[i]);
        }

        bw.write(String.valueOf(combination(weight,N,C)));
        bw.flush();
        bw.close();
    }

    public static int combination(int []weights,int N,int C){
        int mid=N/2;

        List<Long> left=Sum(weights,0,mid);
        List<Long> right=Sum(weights,mid,N);

        Collections.sort(right);

        int result=0;
        for (Long sum : left) {
            Long remaining = C - sum;
            result += upperBound(right, remaining);
        }
        return result;
    }

    public static List<Long> Sum(int []weights,int start,int end){
        List<Long> sum=new ArrayList<>();
        int size=end-start;

        for (int i = 0; i < (1<<size); i++) {
            long temp=0;
            for (int j = 0; j < size; j++) {
                if((i&(1<<j))!=0){
                    temp +=weights[start+j];
                }
            }
            sum.add(temp);
        }
        return sum;
    }

    public static int upperBound(List<Long> right,Long remaining){
        int l=0,r=right.size();

        while(l<r){
            int mid=(l+r)/2;
            if(right.get(mid)<=remaining){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;
    }

}
