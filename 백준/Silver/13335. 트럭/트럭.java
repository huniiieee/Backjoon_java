import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int W;
    public static int L;

    static class Truck implements Comparable<Truck> {
        int weight,place,priority;
        public Truck(int weight,int place,int priority) {
            this.weight=weight;
            this.place=place;
            this.priority=priority;
        }

        @Override
        public int compareTo(Truck o){
            return this.priority - o.priority;
        }
    }


    public static void main(String[] args) throws IOException {
        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        W=Integer.parseInt(input[1]);
        L=Integer.parseInt(input[2]);
        input=br.readLine().split(" ");

        PriorityQueue<Truck> pq=new PriorityQueue<>();
        for(int i=0;i<N;i++){
            pq.offer(new Truck(Integer.parseInt(input[i]),0,i));
        }

        int result=0;
        while(!pq.isEmpty()){

            Truck cur=pq.poll();
            int weight=0;
            cur.place++;
            List<Truck> trucks=new ArrayList<>();
            if(cur.place<=W){
                trucks.add(cur);
                weight=cur.weight;
            }

            while(!pq.isEmpty()){
                Truck temp=pq.peek();

                if(weight+temp.weight<=L &&cur.place>=temp.place+2){
                    cur=pq.poll();
                    cur.place++;
                    weight +=cur.weight;
                    trucks.add(cur);
                }
                else{
                    break;
                }
            }
            for(Truck t:trucks)
                pq.offer(t);

            result++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }



}