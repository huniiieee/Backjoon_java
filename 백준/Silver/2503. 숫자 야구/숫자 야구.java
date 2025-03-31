import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;


    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        int result=0;
        int [][]check =new int [N][3];
        for (int i = 0; i < N; i++) {
            String []input=br.readLine().split(" ");
            check[i][0]=Integer.parseInt(input[0]);
            check[i][1]=Integer.parseInt(input[1]);
            check[i][2]=Integer.parseInt(input[2]);
        }

        for (int i = 123; i <=987 ; i++) {
            String temp=String.valueOf(i);
            if(temp.charAt(1)=='0'||temp.charAt(2)=='0'){
                continue;
            }
            if(temp.charAt(0)==temp.charAt(1) || temp.charAt(1)==temp.charAt(2) || temp.charAt(0)==temp.charAt(2)){
                continue;
            }


            boolean flag=true;
            for (int j = 0; j < N; j++) {
                int question=check[j][0];
                int strike=check[j][1];
                int ball=check[j][2];
                int []answer=count(i,question);
                if(!(answer[0]==strike && answer[1]==ball)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                result++;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static int [] count(int guess,int question){
        int []guesses=new int[3];
        int []questions=new int[3];
        guesses[0]=guess/100;
        questions[0]=question/100;
        guesses[1]=(guess/10)%10;
        questions[1]=(question/10)%10;
        guesses[2]=guess%10;
        questions[2]=question%10;

        int strike=0;
        int ball=0;
        boolean []check=new boolean[10];
        for (int i = 0; i < 3; i++) {
            check[guesses[i]]=true;
            check[questions[i]]=true;
            if(guesses[i]==questions[i]){
                strike++;
            }
        }

        int numberCount=0;
        for (int i = 1; i <=9 ; i++) {
            if(check[i]) numberCount++;
        }

        int strikeOrBallCount=6-numberCount;
        ball=strikeOrBallCount-strike;
        int []result=new int[2];
        result[0]=strike;
        result[1]=ball;
        return result;
    }

}