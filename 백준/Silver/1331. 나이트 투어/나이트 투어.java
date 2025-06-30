import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int [] dx = {-1,-2,-2,-1,1,2,2,1};
    public static int [] dy = {-2,-1,1,2,2,1,-1,-2};

    public static void main(String[] args) throws IOException {
        Map<String,Character> chessPlace =new HashMap<>();
        String cur=br.readLine();
        String start=cur;

        String result="Valid";
        for (int i = 0; i < 35; i++) {
            String next=br.readLine();

            if(!isValid(chessPlace,cur,next)){
                result="Invalid";
                break;
            }
            cur=next;

        }
        if(!isValid(chessPlace,cur,start)) result="Invalid";
        if(result.equals("Valid"))
            if(chessPlace.size()!=36) result="Invalid";
        bw.write(result);
        bw.flush();
        bw.close();
    }

    public static boolean isValid(Map<String,Character> chessPlace,String cur, String next){

        if(chessPlace.containsKey(next)) return false;
        int curX=cur.charAt(0)-'A';
        int curY=cur.charAt(1)-'1';
        int nextX=next.charAt(0)-'A';
        int nextY=next.charAt(1)-'1';

        for (int i = 0; i < 8; i++) {
            if(curX+dx[i] ==nextX && curY+dy[i]==nextY) {
                chessPlace.put(next,'o');
                return true;
            }
        }
        return false;
    }
}