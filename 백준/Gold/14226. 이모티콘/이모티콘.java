
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int S;



    public static void main(String[] args) throws IOException {

        S=Integer.parseInt(br.readLine());
        Queue<short []> q=new LinkedList<>();
        q.offer(new short[]{1,1,1});
        Set<String> visited = new HashSet<>();
        visited.add("1,0");
        while(!q.isEmpty()){
            short [] cur=q.poll();
            short emo=cur[0];
            short cnt=cur[1];
            short clipboard = cur[2];

            if(emo==S){
                bw.write(String.valueOf(cnt));
                break;
            }

            if (!visited.contains(emo + "," + emo)) {
                q.offer(new short[]{emo, (short) (cnt + 1), emo});
                visited.add(emo + "," + emo);
            }
            if (clipboard > 0 && emo + clipboard <= 1000 && !visited.contains((emo + clipboard) + "," + clipboard)) {
                q.offer(new short[]{(short) (emo + clipboard), (short) (cnt + 1), clipboard});
                visited.add((emo + clipboard) + "," + clipboard);
            }
            if (emo > 0 && !visited.contains((emo - 1) + "," + clipboard)) {
                q.offer(new short[]{(short) (emo - 1), (short) (cnt + 1), clipboard});
                visited.add((emo - 1) + "," + clipboard);
            }

        }


        bw.flush();
        bw.close();
    }
}
