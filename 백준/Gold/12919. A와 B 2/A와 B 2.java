import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static boolean result=false;


    public static void main(String[] args) throws IOException {
        String input=br.readLine();
        String output=br.readLine();
        check(input,output);
        if(result) bw.write(String.valueOf(1));
        else bw.write(String.valueOf(0));
        bw.flush();
        bw.close();
    }

    public static void check(String input,String output){
        if(result)
            return;
        if(input.length()==output.length()){
            if(input.equals(output)){
                result=true;
            }
            return;
        }
        if(output.charAt(0)=='B'){
            String subOutput=output.substring(1);
            StringBuilder temp=new StringBuilder(subOutput);
            check(input,temp.reverse().toString());
        }

        if(output.charAt(output.length()-1)=='A'){
            check(input,output.substring(0,output.length()-1));
        }

    }


}