
import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int T;
    public static int K;

    public static void main(String[] args) throws IOException {

        T=Integer.parseInt(br.readLine());
        while(T-- >0){
            String input=br.readLine();
            K=Integer.parseInt(br.readLine());
            List<List<Integer>> alpha=new LinkedList<>();
            for(int i=0;i<26;i++){
                alpha.add(new LinkedList<>());
            }
            int len=input.length();
            for(int i=0;i<len;i++){
                alpha.get((int)(input.charAt(i)-'a')).add(i+1);
            }
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for(int i=0;i<26;i++){
                List<Integer> cur=alpha.get(i);
                if(cur.size()>=K){
                    int cnt=cur.size()-K+1;
                    for(int j=0;j<cnt;j++){
                        int tempLen=cur.get(j+K-1)-cur.get(j)+1;
                        if(tempLen<min){
                            min=tempLen;
                        }
                        if(tempLen>max){
                            max=tempLen;
                        }
                    }
                }
            }
            bw.write(min==Integer.MAX_VALUE? -1+"\n" :min+" "+max+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }


}