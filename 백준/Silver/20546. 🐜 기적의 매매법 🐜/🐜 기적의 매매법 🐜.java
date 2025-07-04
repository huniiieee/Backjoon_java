import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int M;
    public static int day=14;
    public static void main(String[] args) throws IOException {

        M=Integer.parseInt(br.readLine());

        int [] stocks=new int[day];
        String[]input=br.readLine().split(" ");
        for (int i = 0; i < day; i++) {
            stocks[i]=Integer.parseInt(input[i]);
        }
        int jun=junhyun(stocks,M);
        int min=seongmin(stocks,M);
        String result="";
        if(jun>min) result="BNP";
        else if(jun<min) result="TIMING";
        else  result="SAMESAME";
        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }

    public static int junhyun(int []stocks,int money){
        int stockNum=0;
        for (int i = 0; i < day; i++) {
            int num = (money/stocks[i]);
            money-=stocks[i]*num;
            stockNum+=num;
        }
        return money+stockNum*stocks[day-1];
    }

    public static int seongmin(int []stocks,int money){
        int stockNum=0;
        int cash=money;
        int up=0;
        int down=0;
        for (int i = 1; i < day; i++) {
            if(stocks[i]>stocks[i-1]){
                up++;
                down=0;
            }
            else if(stocks[i]<stocks[i-1]){
                down++;
                up=0;
            }
            else{
                up=0;
                down=0;
            }

            if(up>=3){
                cash += (stockNum*stocks[i]);
                stockNum=0;

            }

            if(down>=3){
                int num=cash/stocks[i];
                cash -=stocks[i]*num;
                stockNum +=num;
            }
        }

        return cash+ stockNum*stocks[day-1];

    }



}
