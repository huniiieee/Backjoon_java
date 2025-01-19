
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;

    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        String []input= br.readLine().split(" ");
        int []number= new int[N];
        for (int i = 0; i < N; i++) {
            number[i]=Integer.parseInt(input[i]);
        }
        Arrays.sort(number);
        int result []=new int[2];
        int temp=Integer.MAX_VALUE;
        int left=0;
        int right=N-1;
        while(left<right){
            int sum=number[left]+number[right];
            if((int)Math.abs(sum)<temp){
                result[0]=number[left];
                result[1]=number[right];
                temp=(int)Math.abs(sum);
            }
            if(sum<0){
                left++;
            }
            else if(sum>0){
                right--;
            }
            else{
                result[0]=number[left];
                result[1]=number[right];
                break;
            }
        }
        bw.write(result[0]+" "+result[1]);
        bw.flush();
        bw.close();
    }
}
