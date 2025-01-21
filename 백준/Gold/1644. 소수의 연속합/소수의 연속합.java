
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;

    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        List<Integer> primes = getPrimesUpTo(N);

        int size= primes.size();
        
        int left=0;
        int sum=0;
        int result=0;
        for (int right = 0; right < size; right++) {
            sum+=primes.get(right);
            while(sum>N){
                sum -=primes.get(left);
                left++;
            }
            if(sum==N){
                result++;
            }

        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static List<Integer> getPrimesUpTo(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}
