
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int H;

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0])/2;
        H = Integer.parseInt(input[1]);

        int [] even=new int [N];
        int [] odd=new int[N];
        for (int i = 0; i < 2*N; i++) {
            if(i%2==0){
                even[i/2]=Integer.parseInt(br.readLine());
            }
            else{
                odd[i/2]=H-Integer.parseInt(br.readLine());
            }
        }
        Arrays.sort(even);
        Arrays.sort(odd);

        int result=Integer.MAX_VALUE;
        List<Integer> resulList=new ArrayList<>();
        for (int i = 1; i <= H; i++) {
            int temp=low(even,i)+high(odd,i);
            if(temp<result){
                resulList=new ArrayList<>();
                resulList.add(i);
                result=temp;
            }
            else if(temp==result){
                resulList.add(i);
            }

        }

        bw.write(result+" "+resulList.size());
        bw.flush();
        bw.close();
    }

    public static int low(int []even,int h){
        int left=0,right=N-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(even[mid]<h){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return N-left;
    }

    public static int high(int [] odd,int h){
        int left=0,right=N-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(odd[mid]<h){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return left;
    }
}
