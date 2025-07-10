import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int K;
    public static int M;

    public static void main(String[] args) throws IOException {
        String []input =br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        K=Integer.parseInt(input[1]);
        M=Integer.parseInt(input[2]);
        Deque<Integer> deque=new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        boolean dir=true;
        int m=0;
        while(!deque.isEmpty())
        {
            int size=deque.size();
            for (int i = 0; i < K-1; i++) {
                if(dir)
                    deque.addLast(deque.pollFirst());
                else
                    deque.addFirst(deque.pollLast());
            }
            if(dir)
                bw.write(deque.pollFirst()+"\n");
            else
                bw.write(deque.pollLast()+"\n");
            if(++m==M){
                m=0;
                dir = !dir;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
