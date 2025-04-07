import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;



    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        int []puzzle=new int[N];
        String []input=br.readLine().split(" ");
        for(int i=0;i<N;i++){
            puzzle[i]=Integer.parseInt(input[i]);
        }

        boolean result=true;
        StringTokenizer st=new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int startIndex=0;
        for(int i=0;i<N;i++){
            if(start==puzzle[i]){
                startIndex=i;
            }
        }
        if(N==1){
            if(start!=puzzle[0]){
                result=false;
            }
        }
        else{
            int direction=0;
            int second=Integer.parseInt(st.nextToken());
            if(second==puzzle[(startIndex+N+1)%N])
                direction=1;
            else if(second==puzzle[(startIndex+N-1)%N])
                direction=-1;
            else{
                result=false;
            }
            for(int i=2;i<N;i++){
                if(!result)
                    break;
                if(puzzle[(startIndex+(direction)*i+N)%N]!=Integer.parseInt(st.nextToken())){
                    result=false;
                }
            }
        }

        if(result) bw.write("good puzzle");
        else bw.write("bad puzzle");
        bw.flush();
        bw.close();
    }


}