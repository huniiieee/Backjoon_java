import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int M;



    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        Set<Integer> cards=new HashSet<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            cards.add(Integer.parseInt(st.nextToken()));
        }
        M=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            if(cards.contains(Integer.parseInt(st.nextToken()))){
                bw.write(1+" ");
            }
            else{
                bw.write(0+" ");
            }
        }
        bw.flush();
        bw.close();
    }


}