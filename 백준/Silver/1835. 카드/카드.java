import java.io.*;
import java.util.Deque;
import java.util.LinkedList;



public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;


    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        Deque<Integer> queue =new LinkedList<>();
        queue.offer(N);
        for (int i = N-1; i >=1 ; i--) {

            queue.offerFirst(i);
            for (int j = 0; j < i; j++) {
                queue.offerFirst(queue.pollLast());
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(queue.pollFirst()+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }



}
