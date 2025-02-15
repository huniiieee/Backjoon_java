import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int M;


    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(input[i]);
        }
        M = Integer.parseInt(br.readLine());
        int low=1,high=100000;

        //이분 탐색
        while(low<=high){
            int mid=(low+high)/2;
            int sum=count(money,mid);

            if(sum>M){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        //상한액 설정하지 않아도 예산액 배정이 가능한 경우
        if(low-1==100000){
            bw.write(String.valueOf(Arrays.stream(money).max().orElse(-1)));
        }
        else{
            bw.write(String.valueOf(low-1));
        }
        bw.flush();
        bw.close();
    }

    // 상한액을 max로 설정했을 때 배정되는 총 예산액
    public static int count(int []money,int max){
        int sum=0;
        for (int i = 0; i < N; i++) {
            sum +=Integer.min(money[i],max);
        }
        return sum;
    }
}
