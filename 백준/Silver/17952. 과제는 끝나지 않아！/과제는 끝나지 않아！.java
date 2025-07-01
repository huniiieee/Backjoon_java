import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;

    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        int totalScore=0;
        Stack<int []> tasks = new Stack<>();
        for (int i = 0; i < N; i++) {
            String task=br.readLine();
            if(task.charAt(0)=='0'){
                if(tasks.isEmpty()) continue;
                int []curTask=tasks.pop();
                int time=curTask[1];
                if(time==1){
                    totalScore +=curTask[0];
                    continue;
                }
                curTask[1] -=1;
                tasks.push(curTask);
            }
            else{
                String []temp=task.split(" ");
                int score=Integer.parseInt(temp[1]);
                int time=Integer.parseInt(temp[2]);
                if(time==1){
                    totalScore +=score;
                    continue;
                }
                tasks.push(new int[]{score,time-1});

            }
        }
        bw.write(String.valueOf(totalScore));
        bw.flush();
        bw.close();
        br.close();
    }


}