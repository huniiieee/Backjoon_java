
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static String A;
    public static String B;



    public static void main(String[] args) throws IOException {

        N=Integer.parseInt(br.readLine());
        String []input= new String[N];
        for (int i = 0; i < N; i++) {
            input[i]=br.readLine();
        }
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                char cur=input[i].charAt(j);
                if(map.containsKey(cur)){
                    map.put(cur,map.get(cur)+(int)Math.pow(10,input[i].length()-j-1));
                }
                else{
                    map.put(cur,(int)Math.pow(10,input[i].length()-j-1));
                }
            }
        }
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        int result=0;
        int start=9;

        for(Map.Entry<Character,Integer> entry :entries){
            result += (start*entry.getValue());
            start--;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
