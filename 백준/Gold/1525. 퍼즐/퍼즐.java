import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int []dx={-1,1,0,0};
    public static int []dy={0,0,1,-1};


    public static void main(String[] args) throws IOException {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String []input=br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                sb.append(input[j]);
            }
        }
        String init=sb.toString();
        String answer="123456780";

        Map<String,Integer> map=new HashMap<>();
        map.put(init,0);
        Queue<String> q=new LinkedList<>();
        q.offer(init);

        int result=-1;
        while(!q.isEmpty()){
            String cur=q.poll();
            int cnt=map.get(cur);

            if(cur.equals(answer)){
                result=cnt;
                break;
            }
            int zeroIdx=cur.indexOf('0');
            int x=zeroIdx/3;
            int y=zeroIdx%3;

            for (int i = 0; i < 4; i++) {
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<0||nx>2||ny<0||ny>2) continue;
                int idx=nx*3+ny;

                char temp=cur.charAt(idx);
                String next=cur.replace(temp,'t');
                next=next.replace('0',temp);
                next=next.replace('t','0');

                if(map.containsKey(next)) continue;
                map.put(next,cnt+1);
                q.add(next);
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
