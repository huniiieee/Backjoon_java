import javax.naming.ldap.BasicControl;
import javax.naming.ldap.HasControls;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int P;


    public static void main(String[] args) throws IOException {
        P=Integer.parseInt(br.readLine());

        for (int i = 0; i < P; i++) {
            String []input=br.readLine().split(" ");
            int number=Integer.parseInt(input[0]);
            int first=Integer.parseInt(input[1]);
            List<Integer> list= new LinkedList<>();
            list.add(first);
            int result=0;
            for (int j = 2; j <= 20; j++)
                result += steps(list,Integer.parseInt(input[j]));
            bw.write(number +" "+result+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int steps(List<Integer> list, int height){
        int len=list.size();
        int left=0;
        int right=len-1;
        while(left<=right){
            int mid=(left+right)/2;

            if(list.get(mid)>=height) right =mid-1;
            else left =mid+1;
        }
        list.add(left, height);
        return len-left;
    }
}
