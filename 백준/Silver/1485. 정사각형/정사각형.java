import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int T;


    public static void main(String[] args) throws IOException {
        T=Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int [][] dot=new int[4][2];
            for (int j = 0; j < 4; j++) {
                String [] input=br.readLine().split(" ");
                dot[j][0]=Integer.parseInt(input[0]);
                dot[j][1]=Integer.parseInt(input[1]);
            }

            //정사각형 가능 여부 확인하는 SET
            //각 점에서 점끼리리의 길이들을 SET에 전부 넣었을 때 두가지 값만 있어야 함
            Set<Integer> check=new HashSet<>();
            for (int j = 0; j < 4; j++) {
                for (int k = j+1; k < 4; k++) {
                    int lenSquare=(dot[j][0]-dot[k][0])*(dot[j][0]-dot[k][0])+(dot[j][1]-dot[k][1])*(dot[j][1]-dot[k][1]);
                    check.add(lenSquare);
                }
            }

            if(check.size()==2){
                bw.write(1+"\n");
            }
            else{
                bw.write(0+" ");
            }


        }

        bw.flush();
        bw.close();
    }


}