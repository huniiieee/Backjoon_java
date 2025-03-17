import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int [][]map=new int[9][9];
    public static boolean flag=false;
    public static int [][]result=new int[9][9];


    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            String temp=br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j]=Character.getNumericValue(temp.charAt(j));
            }
        }
        backTrack(0,0);
        for (int i = 0; i < 9; i++) {
            String temp = Arrays.stream(result[i])
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining());
            bw.write(temp+"\n");
        }
        bw.flush();
        bw.close();
    }

    static void backTrack(int r,int c){
        if(flag) return;
        if (r == 9) {   //스도쿠를 전부 채운 경우
            for (int i = 0; i < 9; i++) {
                result[i] = Arrays.copyOf(map[i], 9);
            }
            flag = true;
            return;
        }

        int nr=r;
        int nc=c+1;
        if(nc==9){
            nr+=1;
            nc=0;
        }

        if(map[r][c]!=0){
            backTrack(nr,nc);
            return;
        }
        List<Integer> can = candidate(r,c);
        if(can.isEmpty()){  //전에 설정한 후보 값이 잘못됨
            return;
        }
        for (Integer i : can) {
            map[r][c]=i;
            backTrack(nr,nc);
            if (flag) return;  // 정답을 찾았으면 바로 종료
            map[r][c]=0;    //백트래킹
        }


    }

    static List<Integer> candidate(int r,int c){
        boolean[] visited=new boolean[10];
        for (int i = 0; i < 9; i++) {
            visited[map[r][i]]=true;
            visited[map[i][c]]=true;
        }
        int rowSection=r/3;
        int colSection=c/3;
        for (int i = 3*rowSection; i <3*(rowSection+1) ; i++) {
            for (int j = 3*colSection; j < 3*(colSection+1); j++) {
                visited[map[i][j]]=true;
            }
        }
        List<Integer> list=new ArrayList<>();
        for (int i = 1; i <=9 ; i++) {
            if(!visited[i]){
                list.add(i);
            }
        }
        return list;
    }

}