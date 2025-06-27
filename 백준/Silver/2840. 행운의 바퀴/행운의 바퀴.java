import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int K;



    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        K=Integer.parseInt(input[1]);


        String [] roulette=new String[N];
        Set<String> usedAlphabets = new HashSet<>();
        for (int i = 0; i < N; i++) roulette[i]="";
        input=br.readLine().split(" ");
        roulette[0]=input[1];
        usedAlphabets.add(input[1]);
        int idx=0;

        boolean flag=false;
        for (int i = 0; i < K-1; i++) {
            input=br.readLine().split(" ");
            int num=Integer.parseInt(input[0]);
            String alphabet = input[1];
            idx=(idx+num)%N;
            
            if(!roulette[idx].isEmpty()){
                if(!roulette[idx].equals(alphabet)){
                    flag=true;
                    break;
                }
                // 같은 위치에 같은 알파벳이 오는 경우는 문제없음
            }
            else {
                if(usedAlphabets.contains(alphabet)){
                    flag=true;
                    break;
                }
                roulette[idx]=alphabet;
                usedAlphabets.add(alphabet);
            }
        }

        if(flag)
            bw.write("!");
        else{
            for (int i = 0; i < N; i++) {
                int curIdx=(idx-i+N)%N;
                bw.write(roulette[curIdx].isEmpty() ? "?" : roulette[curIdx]);
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }


}
