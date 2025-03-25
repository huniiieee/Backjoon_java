import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int studentNumber;
    public static int[] button;
    public static int[][]student;


    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        String []input=br.readLine().split(" ");
        button=new int[N+1];
        for (int i = 1; i <= N; i++) {
            button[i]=Integer.parseInt(input[i-1]);
        }
        studentNumber=Integer.parseInt(br.readLine());
        student=new int[studentNumber][2];
        for (int i = 0; i < studentNumber; i++) {
            input=br.readLine().split(" ");
            student[i][0]=Integer.parseInt(input[0]);
            student[i][1]=Integer.parseInt(input[1]);
        }

        for (int i = 0; i < studentNumber; i++) {
            int sex=student[i][0];
            int n=student[i][1];
            if(sex==1){
                boy(n);
            }
            else{
                girl(n);
            }

        }
        for (int i = 1; i <= N; i++) {
            bw.write(button[i]+" ");
            if(i%20==0){
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static void girl(int n){
        button[n]= ((button[n]+1)%2);  //스위치 상태 변경
        for (int i = 1; ; i++) {
            int checkLeft=n-i;
            int checkRight=n+i;
            if(checkLeft<1||checkRight>N){
                break;
            }
            if(!(button[checkLeft]==button[checkRight])){
                break;
            }
            button[checkLeft]= ((button[checkLeft]+1)%2);
            button[checkRight]= ((button[checkRight]+1)%2);
        }
    }

    public static void boy(int n){
        for (int i = 1;  ; i++) {
            if(n*i>N){
                break;
            }
            button[n*i]= ((button[n*i]+1)%2);
        }
    }

}