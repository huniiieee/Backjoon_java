import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        L=Integer.parseInt(input[1]);

        int [][] map=new int[N][N];
        for(int i=0;i<N;i++){
            String [] line=br.readLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(line[j]);
            }
        }
        int answer=0;
        for(int i=0;i<N;i++){
            if(checkRow(map,i)){
                answer ++;
            }
            if(checkCol(map,i)){
                answer++;
            }
        }
        System.out.println(answer);

    }

    public static boolean checkRow(int [][] map,int r){
        boolean []visited=new boolean[N];
        for(int i=0;i<N-1;i++){
            if(map[r][i]==map[r][i+1]) continue;
            else if(map[r][i]-map[r][i+1]==1){
                for(int j=i+1;j<=i+L;j++){
                    if(j>=N)return false;
                    if(map[r][i+1]!=map[r][j])return false;
                    visited[j]=true;
                }
                i+=L-1;
            }
            else if(map[r][i]-map[r][i+1]==-1){
                for(int j=i;j>i-L;j--){
                    if(j<0)return false;
                    if(map[r][i]!=map[r][j])return false;
                    if(visited[j])return false;
                }
            }
            else return false;
        }
        return true;
    }

    public static boolean checkCol(int [][] map,int c){
        boolean []visited=new boolean[N];
        for(int i=0;i<N-1;i++){
            if(map[i][c]==map[i+1][c]) continue;
            else if(map[i][c]-map[i+1][c]==1){
                for(int j=i+1;j<=i+L;j++){
                    if(j>=N)return false;
                    if(map[i+1][c]!=map[j][c])return false;
                    visited[j]=true;
                }
                i+=L-1;
            }
            else if(map[i][c]-map[i+1][c]==-1){
                for(int j=i;j>i-L;j--){
                    if(j<0)return false;
                    if(map[i][c]!=map[j][c])return false;
                    if(visited[j])return false;
                }
            }
            else return false;
        }
        return true;
    }
}
