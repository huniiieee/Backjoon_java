import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;



    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());

        int []start=new int[N];
        int []wanted=new int[N];
        String startInput=br.readLine();
        int []firstChange =new int[N];//처음 스위치를 누른 경우
        String wantedInput=br.readLine();
        for (int i = 0; i <N ; i++) {
            start[i]=Character.getNumericValue(startInput.charAt(i));
            firstChange[i]=Character.getNumericValue(startInput.charAt(i));
            wanted[i]=Character.getNumericValue(wantedInput.charAt(i));
        }
        
        // 처음 스위치 누르지 않고 원하는 상태 만들지 못한 경우
        int result=check(start,wanted);
        if(result==-1){
            change(firstChange,0);
            result=check(firstChange,wanted);
            if(result!=-1){
                result++;
            }
            bw.write(String.valueOf(result));
        }
        else{
            bw.write(String.valueOf(result));
        }

        bw.flush();
        bw.close();
    }

    static void change(int []button,int n){
        button[n]=(button[n]+1)%2;
        if(n==0){
            button[n+1]=(button[n+1]+1)%2;
        }
        else if(n==N-1){
            button[n-1] = (button[n-1]+1)%2;
        }
        else{
            button[n-1] = (button[n-1]+1)%2;
            button[n+1]=(button[n+1]+1)%2;
        }
    }

    static int check(int []button,int []wanted){
        int result=0;
        for (int i = 1; i < N; i++) {
            if(i==N-1){
                if(button[i-1]==wanted[i-1] && button[i]==wanted[i]) break;
                else if(button[i-1]!=wanted[i-1] && button[i]!=wanted[i]) result++;
                else result=-1;
                break;
            }
            if(button[i-1]!=wanted[i-1]){
                result++;
                change(button,i);
            }
        }
        return result;
    }

}