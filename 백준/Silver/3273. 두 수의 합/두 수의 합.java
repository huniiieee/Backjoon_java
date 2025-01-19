
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int X;

    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        String []input= br.readLine().split(" ");
        int []number= new int[N];
        for (int i = 0; i < N; i++) {
            number[i]=Integer.parseInt(input[i]);
        }
        X=Integer.parseInt(br.readLine());
        Arrays.sort(number);
        int result=0;

        int left=0;
        int right=N-1;
        while(left<right){
            int sum=number[left]+number[right];
            if(sum==X){
                result++;
                left++;
                right--;
            }
            else if(sum>X){
                right--;
            }
            else{
                left++;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
