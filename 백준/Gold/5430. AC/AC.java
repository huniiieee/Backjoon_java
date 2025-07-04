import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String methods = br.readLine();
            int size = Integer.parseInt(br.readLine());
            String string = br.readLine();
            Deque<Integer> deque = parseToDeque(string);

            boolean reverse = false;
            boolean error = false;

            for (char method : methods.toCharArray()) {
                if (method == 'R') {
                    reverse = !reverse;
                } else if (method == 'D') {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (reverse) {
                        deque.pollLast(); 
                    } else {
                        deque.pollFirst(); 
                    }
                }
            }

            if (error) {
                bw.write("error\n");
            } else {
                bw.write(dequeToString(deque, reverse));
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static Deque<Integer> parseToDeque(String s) {
        Deque<Integer> deque = new LinkedList<>();
        s = s.substring(1, s.length() - 1); 
        if (s.isEmpty()) return deque;

        String[] nums = s.split(",");
        for (String num : nums) {
            deque.add(Integer.parseInt(num));
        }
        return deque;
    }

    public static String dequeToString(Deque<Integer> deque, boolean reverse) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (reverse) {
            Iterator<Integer> it = deque.descendingIterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) sb.append(",");
            }
        } else {
            Iterator<Integer> it = deque.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
