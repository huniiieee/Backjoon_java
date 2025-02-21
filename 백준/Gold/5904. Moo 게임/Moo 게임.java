

import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;


    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        int len=3;
        int prevLen=3;
        int k=0;

        //N보다 큰 수열의 길이 구하기
        while(len<N){
            k++;
            prevLen=len;
            len=2*prevLen +(k+3);
        }
        check(len,k);
        bw.flush();
        bw.close();
    }


    public static void check(int len,int k) throws IOException {
        if(k==0){
            if(N==1){
                bw.write("m");
            }
            else{
                bw.write("o");
            }
            return;
        }
        int prevLen=(len-(k+3))/2;

        //이전 수열에 N이 존재
        if(N<=prevLen){
            check(prevLen,k-1);
        }

        //이전 수열 사이에 N이 존재
        else if(prevLen+1<=N && N<prevLen+(k+3)){
            if(prevLen+1==N){
                bw.write("m");
            }
            else{
                bw.write("o");
            }
        }

        //반복된 이전 수열에 N이 존재
        else{
            N -= (prevLen+k+3);
            check(prevLen,k-1);
        }
    }
}
