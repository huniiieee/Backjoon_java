import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int N;
    public static int zero;
    public static int plus;
    public static int minus;


    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        byte [][] paper = new byte[N][N];
        for (int i = 0; i < N; i++) {
            String []input=br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                paper[i][j]=Byte.parseByte(input[j]);
            }
        }
        result(paper,0,0,N);
        bw.write(minus+"\n"+zero+"\n"+plus);
        bw.flush();
        bw.close();
    }

    public static int check(byte [][] paper,int row,int col, int size){
        byte tmp=paper[row][col];
        boolean flag=false;
        for (int i = row; i < row+size; i++) {
            for (int j = col; j < col+size; j++) {
                if(paper[i][j]!=tmp){
                    flag=true;
                    break;
                }
            }
            //종이에 적힌 수가 모두 같은 경우가 아닌 경우 100으로 판단
            if(flag){
                return 100;
            }
        }

        //종이에 적힌 수가 모두 같은 경우 그 수를 return
        return tmp;
    }

    public static void result(byte [][]paper,int row,int col, int size){
        int tmp=check(paper,row,col,size);
        
        if(tmp==0){
            zero++;
            return;
        }
        else if(tmp==1){
            plus++;
            return;
        }
        else if(tmp==-1){
            minus++;
            return;
        }
        else{
            int newSize=size/3;
            result(paper,row,col,newSize);
            result(paper,row+newSize,col,newSize);
            result(paper,row+newSize*2,col,newSize);
            result(paper,row,col+newSize,newSize);
            result(paper,row,col+newSize*2,newSize);
            result(paper,row+newSize,col+newSize,newSize);
            result(paper,row+newSize*2,col+newSize,newSize);
            result(paper,row+newSize,col+newSize*2,newSize);
            result(paper,row+newSize*2,col+newSize*2,newSize);
        }
    }


}
