
import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;


    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        long []numbers=new long[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            numbers[i]=Long.parseLong(stringTokenizer.nextToken());
        }
        Arrays.sort(numbers);
        int cnt=0;
        for(int i=0;i<N;i++){
            long cur=numbers[i];
            int left=0;
            int right=N-1;
            while(left<right){
                long sum=numbers[left]+numbers[right];
                if(sum==cur){
                    if(left==i){
                        left++;
                        continue;
                    }
                    if(right==i){
                        right--;
                        continue;
                    }
                    cnt++;
                    break;
                }
                else if(sum>cur){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }


}