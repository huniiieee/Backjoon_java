import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int K;
    public static int cnt=0;


    static class Belt{
        int w;
        boolean isRobot;
        public Belt(int w){
            this.w=w;
            this.isRobot=false;
        }

        public void upRobot(){
            this.isRobot=true;
            this.w -=1;
            if(this.w==0){
                cnt++;
            }
        }
        public void downRobot(){
            if(this.isRobot)
                this.isRobot=false;
        }


    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st =new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        List<Belt> belts =new LinkedList<>();
        st =new StringTokenizer(br.readLine());
        for(int i=0;i<N*2;i++){
            belts.add(new Belt(Integer.parseInt(st.nextToken())));
        }
        int result=0;
        while(cnt<K){
            Belt down=belts.remove(2*N-1);
            belts.add(0,down);
            down=belts.get(N-1);
            down.downRobot();
            for(int i=N-2;i>=0;i--){
                if(belts.get(i).isRobot&&!belts.get(i+1).isRobot&&belts.get(i+1).w>=1){
                    belts.get(i).downRobot();
                    belts.get(i+1).upRobot();
                }
            }
            down.downRobot();
            Belt first=belts.get(0);
            if(!first.isRobot&&first.w>=1){
                first.upRobot();
            }
            result++;
        }
        bw.write(String.valueOf(result));
        bw.close();
    }


}