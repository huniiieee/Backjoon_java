import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static long X;
    public static long [] patty,len;

    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        X=Long.parseLong(input[1]);
        patty=new long[N+1];
        len=new long[N+1];
        patty[0]=1;
        len[0]=1;
        for (int i = 1; i <=N ; i++) {
            patty[i]=patty[i-1]*2+1;
            len[i]=len[i-1]*2+3;
        }
        bw.write(String.valueOf(result(N,X)));
        bw.flush();
        bw.close();
    }

    public static long result(int level,long x){
        if(level==0){
            if(x==0){
                return 0;
            }
            else{
                return 1;
            }
        }

        if(level>=x){
            return 0;
        }

        if(len[level]==x){
            return patty[level];
        }
        //전 level햄버거 첫 번째
        if(x<=1+len[level-1]){
            return result(level-1,x-1);
        }
        //전 level햄버거 + 가운데 patty
        else if(x==2+len[level-1]){
            return 1+patty[level-1];
        }
        // 반복되는 전 level햄버거 두 번째
        else{
            return 1+patty[level-1]+result(level-1,x-2-len[level-1]);
        }
    }


}
