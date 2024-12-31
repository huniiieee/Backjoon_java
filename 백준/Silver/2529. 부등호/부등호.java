
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int k;

    public static String result = "";

    public static void backtrackingMax(String [] input ,boolean [] visited,int pre,int cnt,String temp) {
        if(!result.isEmpty())
            return;
        if(cnt==k)
        {
            result=temp;
            return;
        }

        for (int i = 9; i >= 0; i--) {
            if(!visited[i])
            {
                visited[i]=true;
                if(input[cnt].equals("<")){
                    if(i>pre)
                        backtrackingMax(input,visited,i,cnt+1,temp+i);
                }
                else{
                    if(i<pre)
                        backtrackingMax(input,visited,i,cnt+1,temp+i);
                }
                visited[i]=false;
            }

        }
    }

    public static void backtrackingMin(String [] input ,boolean[]visited,int pre,int cnt,String temp) {
        if(!result.isEmpty())
            return;
        if(cnt==k)
        {
            result=temp;
            return;
        }

        for (int i = 0; i <=9; i++) {
            if(!visited[i])
            {
                visited[i]=true;
                if(input[cnt].equals("<")){
                    if(i>pre)
                        backtrackingMin(input,visited,i,cnt+1,temp+i);
                }
                else{
                    if(i<pre)
                        backtrackingMin(input,visited,i,cnt+1,temp+i);
                }
                visited[i]=false;
            }

        }
    }

    public static void main(String[] args) throws IOException {

        k = Integer.parseInt(br.readLine());

        String []input=br.readLine().split(" ");

        boolean[]visited= new boolean[10];
        for (int i = 9; i >=0 ; i--) {
            visited[i]=true;
            backtrackingMax(input,visited,i,0,i+"");
            if(!result.isEmpty()){
                bw.write(String.valueOf(result)+"\n");
                break;
            }
            visited[i]=false;
        }
        result="";
        for (int i = 0; i < 10; i++) {
            visited[i]=false;
        }
        for (int i = 0; i <=9 ; i++) {
            visited[i]=true;
            backtrackingMin(input,visited,i,0,i+"");
            if(!result.isEmpty()){
                bw.write(String.valueOf(result));
                break;
            }
            visited[i]=false;
        }
        bw.flush();
        bw.close();
    }
}
