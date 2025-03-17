import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int K;
    public static long result=0;


    public static class Jewel{
        public int weight;
        public int price;
        public Jewel(int weight,int price){
            this.weight=weight;
            this.price=price;
        }

    }

    public static void main(String[] args) throws IOException {
        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        K=Integer.parseInt(input[1]);

        PriorityQueue<Jewel> jewels=new PriorityQueue<>((o1,o2)->o1.weight-o2.weight); //보석
        PriorityQueue<Jewel> candidates=new PriorityQueue<>((o1,o2)->o1.price==o2.price ?o1.weight-o2.weight:o2.price-o1.price); //현재 가방에 넣을 수 있는 보석들
        PriorityQueue<Integer> bags=new PriorityQueue<>((o1,o2)->o1-o2); //가방의 최대 무게
        for (int i = 0; i < N; i++) {
            input=br.readLine().split(" ");
            int weight=Integer.parseInt(input[0]);
            int price=Integer.parseInt(input[1]);
            jewels.offer(new Jewel(weight,price));
        }
        for (int i = 0; i < K; i++) {
            bags.offer(Integer.parseInt(br.readLine()));
        }

        while(!bags.isEmpty()){
            int bag=bags.poll();

            while(!jewels.isEmpty()){       //가능한 보석들 전부 후보에 추가
                if(bag<jewels.peek().weight) break;
                candidates.offer(jewels.poll());
            }

            if(!candidates.isEmpty()){      //후보 중에서 가장 비싼 보석 가방에 넣기
                result +=candidates.poll().price;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

}