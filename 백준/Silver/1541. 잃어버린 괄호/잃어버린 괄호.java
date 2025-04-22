import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;


    public static void main(String[] args) throws IOException {

        String input=br.readLine();
        String copy=input;
        List<Character> opes=new ArrayList<>();
        List<Integer> numbers=new ArrayList<>();
        copy=copy.replace('+','-');
        String [] numString=copy.split("-");

        int sum=0;
        for (String s : numString) {
            int number=Integer.parseInt(s);
            numbers.add(number);
            sum +=number;
        }
        for(int i=0;i<input.length();i++){
            char temp=input.charAt(i);
            if(temp=='-'||temp=='+') opes.add(temp);
        }


        int minusTotal=0;
        boolean flag=false;
        for(int i=0;i<opes.size();i++){
            if(flag){
                minusTotal +=numbers.get(i+1);
                continue;
            }
            char ope= opes.get(i);
            if(ope=='-'){
                flag=true;
                minusTotal +=numbers.get(i+1);
            }
        }
        bw.write(String.valueOf(sum-minusTotal*2));
        bw.flush();
        bw.close();
        br.close();
    }


}