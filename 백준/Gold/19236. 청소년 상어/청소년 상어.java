import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static int []dx={-1,-1,0,1,1,1,0,-1};
    public static int []dy={0,-1,-1,-1,0,1,1,1};

    public static int sharkX=0;
    public static int sharkY=0;
    public static int sharkDirection=0;
    public static int result=0;
    public static int [][]directionMatrix;
    public static int [][]placeMatrix;
    public static int [][]numberMatrix;


    public static void main(String[] args) throws IOException {

        directionMatrix=new int[4][4];
        placeMatrix=new int[16][2];
        numberMatrix=new int[4][4];

        for (int i = 0; i < 4; i++) {
            String []input=br.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                int number=Integer.parseInt(input[j*2]);
                int direction=Integer.parseInt(input[2*j+1]);
                placeMatrix[number-1][0]=i;
                placeMatrix[number-1][1]=j;
                directionMatrix[i][j]=direction-1;
                numberMatrix[i][j]=number-1;
                if(i==0&&j==0){
                    placeMatrix[number-1][0]=-1;  //상어한테 잡아먹힘
                    placeMatrix[number-1][1]=-1;  //상어한테 잡아먹힘
                    numberMatrix[i][j]=-1;
                    directionMatrix[i][j]=-1;
                    sharkDirection=direction-1;
                    result +=number;
                }
            }
        }
        backTrack(sharkX,sharkY,sharkDirection,result,0);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static void move(){
        for (int i = 0; i < 16; i++) {
            int x=placeMatrix[i][0];
            int y=placeMatrix[i][1];
            if((x==-1&&y==-1)||(x==-2&&y==-2)){  //빈칸 or 상어
                continue;
            }

            int direction=directionMatrix[x][y];
            for (int j = 0; j < 8; j++) {            //방향 전환
                int nextDirection=(direction+j)%8;
                int nx=x+dx[nextDirection];
                int ny=y+dy[nextDirection];
                if(nx>=0&&ny>=0&&nx<4&&ny<4&&numberMatrix[nx][ny]!=-1){
                    int change=numberMatrix[nx][ny];
                    if(change==-2){            //빈칸
                        numberMatrix[nx][ny]=i;
                        directionMatrix[nx][ny]=nextDirection;
                        placeMatrix[i][0]=nx;
                        placeMatrix[i][1]=ny;
                        numberMatrix[x][y]=-2;
                        directionMatrix[x][y]=-2;
                        break;
                    }
                    //상어끼리 위치변경
                    numberMatrix[x][y]=change;
                    numberMatrix[nx][ny]=i;

                    directionMatrix[x][y]=directionMatrix[nx][ny];
                    directionMatrix[nx][ny]=nextDirection;

                    placeMatrix[change][0]=x;
                    placeMatrix[change][1]=y;
                    placeMatrix[i][0]=nx;
                    placeMatrix[i][1]=ny;
                    break;
                }
            }

        }
    }


    public static void backTrack(int x,int y,int direction,int total,int cnt){
        result=Integer.max(result,total);
        
        //백트래킹을 위해 배열 저장 
        int [][]tempNumberMatrix=new int[4][4];
        int [][]tempDirectionMatrix=new int[4][4];
        int [][]tempPlaceMatrix=new int[16][2];
        for (int j = 0; j < 4; j++) {
            tempNumberMatrix[j] = Arrays.copyOf(numberMatrix[j], 4);
            tempDirectionMatrix[j] = Arrays.copyOf(directionMatrix[j], 4);
        }
        for (int j = 0; j < 16; j++) {
            tempPlaceMatrix[j] = Arrays.copyOf(placeMatrix[j], 2);
        }
        move();
        //한 칸씩 확인
        for (int i = 1; i <= 3; i++) {
            int nx=x+dx[direction]*i;
            int ny=y+dy[direction]*i;
            if(nx>=0&&ny>=0&&nx<4&&ny<4&&numberMatrix[nx][ny]>=0){

                int number=numberMatrix[nx][ny];
                int newDirection=directionMatrix[nx][ny];

                numberMatrix[x][y]=-2; // 빈칸
                numberMatrix[nx][ny]=-1; //상어
                placeMatrix[number][0]=-1;
                placeMatrix[number][1]=-1;
                directionMatrix[nx][ny]=-1;
                backTrack(nx,ny,newDirection,total+number+1,cnt+1);
                numberMatrix[nx][ny]=number;
                placeMatrix[number][0]=nx;
                placeMatrix[number][1]=ny;
                directionMatrix[nx][ny]=newDirection;
                numberMatrix[x][y]=-1;
            }
        }
        for (int j = 0; j < 4; j++) {
            numberMatrix[j] = Arrays.copyOf(tempNumberMatrix[j], 4);
            directionMatrix[j] = Arrays.copyOf(tempDirectionMatrix[j], 4);
        }
        for (int j = 0; j < 16; j++) {
            placeMatrix[j] = Arrays.copyOf(tempPlaceMatrix[j], 2);
        }

    }

}