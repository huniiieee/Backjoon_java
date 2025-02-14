
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int C;


    public static void main(String[] args) throws IOException {

        String[] input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        C=Integer.parseInt(input[1]);

        int []house=new int[N];
        for (int i = 0; i < N; i++) {
            house[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);
        int high=house[N-1]-house[0];
        int low=1;
        while(low<=high){
            int mid=(low+high)/2;

            int cnt=count(house,mid);

            if(cnt>=C){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        bw.write(String.valueOf(low-1));
        bw.flush();
        bw.close();
    }

    //최소 거리 설정햇을 때 최대로 설치 가능한 공유기 수
    public static int count(int []house,int dis){
        int cnt=1;
        int pre=house[0];
        for (int i = 1; i < N; i++) {
            if(house[i]-pre>=dis){
                pre=house[i];
                cnt++;
            }
        }
        return cnt;
    }
}
