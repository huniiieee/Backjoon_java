
// don't place package name.
import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int max=Integer.MIN_VALUE;

    public static void backtracking(List<Integer> number,int sum){
        if(number.size()==3){
            sum+=number.get(0)*number.get(2);
            if(sum>max)
                max=sum;
            return;
        }
        for (int i = 1; i < number.size()-1; i++) {
            int sideMul=number.get(i-1)*number.get(i+1);
            int remove=number.get(i);
            number.remove(i);
            backtracking(number,sum+sideMul);
            number.add(i,remove);
        }

    }
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        String [] input=br.readLine().split(" ");
        List<Integer> number=new LinkedList<>();
        for (int i = 0; i < N; i++) {
            number.add(Integer.parseInt(input[i]));
        }

        backtracking(number,0);
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
