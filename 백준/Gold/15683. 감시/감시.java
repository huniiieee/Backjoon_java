import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;
    public static int M;
    public static int count;
    public static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        String []input=br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);

        List<int []> cctvs=new LinkedList<>();
        int [][]map=new int[N][M];
        for (int i = 0; i < N; i++) {
            input=br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(input[j]);
                if(map[i][j]>0 && map[i][j]<6){
                    cctvs.add(new int[]{i,j,map[i][j]});
                }
            }
        }
        count=cctvs.size();
        backtracking(map,cctvs,0);

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void backtracking(int [][]map,List<int []>cctvs,int cnt){
        if(cnt==count){
            min=Integer.min(min,result(map));
            return;
        }

        int []cur=cctvs.get(cnt);
        int x=cur[0];
        int y=cur[1];
        int cctv=cur[2];
        int [][]tmp;
        if(cctv==1){
            tmp=copy(map);
            lookUp(tmp,x,y);
            backtracking(tmp,cctvs,cnt+1);

            tmp=copy(map);
            lookRight(tmp,x,y);
            backtracking(tmp,cctvs,cnt+1);

            tmp=copy(map);
            lookDown(tmp,x,y);
            backtracking(tmp,cctvs,cnt+1);

            tmp=copy(map);
            lookLeft(tmp,x,y);
            backtracking(tmp,cctvs,cnt+1);
        }
        else if(cctv==2){
            tmp=copy(map);
            lookUp(tmp,x,y);
            lookDown(tmp,x,y);
            backtracking(tmp,cctvs,cnt+1);

            tmp=copy(map);
            lookRight(tmp,x,y);
            lookLeft(tmp,x,y);
            backtracking(tmp,cctvs,cnt+1);
        }
        else if(cctv==3){
            tmp=copy(map);
            lookUp(tmp,x,y);
            lookRight(tmp,x,y);
            backtracking(tmp,cctvs,cnt+1);

            tmp=copy(map);
            lookDown(tmp,x,y);
            lookRight(tmp,x,y);
            backtracking(tmp,cctvs,cnt+1);

            tmp=copy(map);
            lookDown(tmp,x,y);
            lookLeft(tmp,x,y);
            backtracking(tmp,cctvs,cnt+1);

            tmp=copy(map);
            lookUp(tmp,x,y);
            lookLeft(tmp,x,y);
            backtracking(tmp,cctvs,cnt+1);
        }
        else if(cctv==4){
            tmp=copy(map);
            lookUp(tmp,x,y);
            lookRight(tmp,x,y);
            lookDown(tmp,x,y);
            backtracking(tmp,cctvs,cnt+1);

            tmp=copy(map);
            lookLeft(tmp,x,y);
            lookRight(tmp,x,y);
            lookDown(tmp,x,y);
            backtracking(tmp,cctvs,cnt+1);

            tmp=copy(map);
            lookUp(tmp,x,y);
            lookLeft(tmp,x,y);
            lookDown(tmp,x,y);
            backtracking(tmp,cctvs,cnt+1);

            tmp=copy(map);
            lookUp(tmp,x,y);
            lookRight(tmp,x,y);
            lookLeft(tmp,x,y);
            backtracking(tmp,cctvs,cnt+1);
        }
        else if(cctv==5){
            tmp=copy(map);
            lookUp(tmp,x,y);
            lookRight(tmp,x,y);
            lookLeft(tmp,x,y);
            lookDown(tmp,x,y);
            backtracking(tmp,cctvs,cnt+1);
        }
    }
    public static void lookUp(int [][]map,int i,int j){
        for (int k = i-1; k >= 0; k--) {
            if(map[k][j]==6) return;
            if(map[k][j]!=0) continue;
            map[k][j]=-1;
        }
    }

    public static void lookRight(int [][]map,int i,int j){
        for (int k = j+1; k < M; k++) {
            if(map[i][k]==6) return;
            if(map[i][k]!=0) continue;
            map[i][k]=-1;
        }
    }

    public static void lookDown(int [][]map,int i,int j){
        for (int k = i+1; k < N; k++) {
            if(map[k][j]==6) return;
            if(map[k][j]!=0) continue;
            map[k][j]=-1;
        }
    }

    public static void lookLeft(int [][]map,int i,int j){
        for (int k = j-1; k >=0 ; k--) {
            if(map[i][k]==6) return;
            if(map[i][k]!=0) continue;
            map[i][k]=-1;
        }
    }

    public static int [][] copy(int [][]map){
        int [][]temp=new int[N][M];
        for (int i = 0; i < N; i++) {
            temp[i] = map[i].clone();
        }
        return temp;
    }

    public static int result(int [][]map){
        int cnt=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cnt = cnt + ((map[i][j]==0) ? 1 : 0);
            }
        }
        return cnt;
    }
}
