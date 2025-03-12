import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));



    public static void main(String[] args) throws IOException {

        Map<Integer,Integer> originalMap=new HashMap<>();
        for (int i = 0; i < 8; i++) {
            originalMap.put(i+1,Integer.parseInt(br.readLine()));
        }
        br.close();
        //value 기준 내림차순
        Map<Integer,Integer> sortedMap=new TreeMap<>((k1,k2)->originalMap.get(k2).compareTo(originalMap.get(k1)));
        sortedMap.putAll(originalMap);

        Iterator<Map.Entry<Integer,Integer>> iterator=sortedMap.entrySet().iterator();
        int count=0;
        int score=0;

        int []quizNum=new int[5];
        while(iterator.hasNext()&&count<5){
            Map.Entry<Integer,Integer> entry=iterator.next();
            score +=entry.getValue();
            quizNum[count++]=entry.getKey();
        }
        bw.write(score+"\n");
        Arrays.sort(quizNum);

        for (int i = 0; i < 5; i++) {
            bw.write(quizNum[i]+" ");
        }
        bw.flush();
        bw.close();
    }


}