import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;


    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        long [] liquid=new long[N];
        String []input=br.readLine().split(" ");
        for(int i=0;i<N;i++){
            liquid[i]=Long.parseLong(input[i]);
        }
        
        //투 포인터 사용하기 위해 정렬
        Arrays.sort(liquid);
        
        long min=Long.MAX_VALUE;
        long first=0,second=0,third=0;
        boolean flag=false;

        for (int i = 0; i <=N-3; i++) {
            
            //값 고정 
            long fix= liquid[i];
            
            //양 끝 포인터 설정
            int left=i+1;
            int right=N-1;

            while(left<right){
                long temp=fix+liquid[left]+liquid[right];
                
                //최솟값 구하기
                if(Math.abs(temp)<min){
                    min=Math.abs(temp);
                    first=fix;
                    second=liquid[left];
                    third=liquid[right];
                }

                if(temp>0){
                    right--;
                }
                else if(temp<0){
                    left++;
                }
                else{  // 0 이라면 더 할 필요 X
                    flag=true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        bw.write(first+" "+second+" "+third);
        bw.flush();
        bw.flush();
        bw.close();
    }


}