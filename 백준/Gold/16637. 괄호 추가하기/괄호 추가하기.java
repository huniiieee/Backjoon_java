import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static String string;
    public static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        string = br.readLine();
        List<Integer> numbers= new LinkedList<>();
        List<Character> commands= new LinkedList<>();

        for(int i=0;i<string.length();i++){
            if(i%2==0){
                numbers.add(Character.getNumericValue(string.charAt(i)));
            }
            else{
                commands.add(string.charAt(i));
            }
        }
        dfs(numbers.get(0),0,numbers,commands);
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    public static void dfs(int temp,int comIdx, List<Integer> numbers, List<Character> commands){
        if(comIdx == commands.size()){
            max=Integer.max(max,temp);
            return;
        }

        dfs(cal(temp,numbers.get(comIdx+1),commands.get(comIdx)),comIdx+1,numbers,commands);
        if(comIdx+1<commands.size()){
            int first=cal(numbers.get(comIdx+1),numbers.get(comIdx+2),commands.get(comIdx+1));
            dfs(cal(temp,first,commands.get(comIdx)),comIdx+2,numbers,commands);
        }

    }

    public static int cal(int num1,int num2, Character ope){
        if(ope.equals('+')){
            return num1+num2;
        }
        else if(ope.equals('-')){
            return num1-num2;
        }
        return num1*num2;

    }
}