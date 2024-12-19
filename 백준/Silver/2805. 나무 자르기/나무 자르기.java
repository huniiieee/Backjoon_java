import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static int N;
    public static Long num;
    public static Long[] arr1;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        num = Long.parseLong(st.nextToken());
        arr1=new Long[N];
        
        long max=Long.MIN_VALUE;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr1[i]=Long.parseLong(st.nextToken());
            if(arr1[i]>max)
                max=arr1[i];
        }
        
        long low=0;
        long high=max;
        long mid=0;   
        long result=0;
        
        while(low<=high)
        {
            mid=(low+high)/2;
            
            long temp=0;
            for(int i=0;i<N;i++)
            {
                if(arr1[i]>mid)
                    temp +=(arr1[i]-mid);
            }
            
            if(temp==num)
            {
                result=mid;
                break;
            }
            if(temp>num){
                low=mid+1;
                result=mid;
            }
            else
                high=mid-1;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
    
}
