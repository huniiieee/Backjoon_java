

import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int S;

    public static void main(String[] args) throws IOException {

        String []input= br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        S=Integer.parseInt(input[1]);
        input=br.readLine().split(" ");
        int []number= new int[N];

        for (int i = 0; i < N; i++) {
            number[i]=Integer.parseInt(input[i]);
        }

        int result =Integer.MAX_VALUE;

        int left=0,sum=0;
        for (int right = 0; right < N; right++) {
            sum +=number[right];

            while(sum>=S){
                result=Math.min(result,right-left+1);
                sum -=number[left];
                left++;
            }
        }

        bw.write(String.valueOf(result!=Integer.MAX_VALUE ? result : 0));
        bw.flush();
        bw.close();
    }
}
