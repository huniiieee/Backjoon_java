import javax.management.monitor.StringMonitor;
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int p;
    public static int m;

    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        p=Integer.parseInt(input[0]);
        m=Integer.parseInt(input[1])+1;

        List<Map<String,Integer>> list = new LinkedList<>();
        for (int i = 0; i < p; i++) {
            input=br.readLine().split(" ");
            int level=Integer.parseInt(input[0]);
            String name=input[1];

            int size=list.size();
            boolean flag=true;
            for (int j = 0; j < size; j++) {
                Map<String,Integer> cur=list.get(j);
                if(Math.abs(cur.get("START")-level)<=10&&cur.size()!=m){
                    cur.put(name,level);
                    flag=false;
                    break;
                }
            }
            if(flag){
                Map<String,Integer> temp=new TreeMap<>();
                temp.put(name, level);
                temp.put("START",level);
                list.add(temp);
            }
        }

        for(Map<String,Integer> map:list){
            if(map.size()==m) bw.write("Started!"+"\n");
            else bw.write("Waiting!"+"\n");

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getKey().equals("START")) continue;
                bw.write(entry.getValue()+" "+entry.getKey()+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
