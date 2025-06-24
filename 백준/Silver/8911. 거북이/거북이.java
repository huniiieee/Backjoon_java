import java.io.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int T;

    public static class turtle{
        String controlProgram;
        int direction;
        int maxR;
        int maxC;
        int minR;
        int minC;
        int r,c;

        public turtle(String controlProgram){
            this.controlProgram=controlProgram;
            this.direction=0;
            int r=0;
            int c=0;
            maxR=0;
            maxC=0;
            minR=0;
            minC=0;
        }

        public void rotateR(){
            this.direction =(this.direction+3)%4;
        }

        public void rotateL(){
            this.direction=(this.direction+1)%4;
        }

        public void forward(){
            if(direction==0){
                r -=1;
                minR= Integer.min(r,minR);
            }
            else if(direction==1){
                c -=1;
                minC=Integer.min(c,minC);
            }
            else if(direction==2){
                r +=1;
                maxR=Integer.max(r,maxR);
            }
            else{
                c+=1;
                maxC=Integer.max(c,maxC);
            }
        }

        public void back(){
            if(direction==2){
                r -=1;
                minR= Integer.min(r,minR);
            }
            else if(direction==3){
                c -=1;
                minC=Integer.min(c,minC);
            }
            else if(direction==0){
                r +=1;
                maxR=Integer.max(r,maxR);
            }
            else{
                c+=1;
                maxC=Integer.max(c,maxC);
            }
        }
        public int result(){
            int len=this.controlProgram.length();
            for (int i = 0; i < len; i++) {
                char control=this.controlProgram.charAt(i);
                if(control=='F') this.forward();
                else if(control=='B') this.back();
                else if(control=='L') this.rotateL();
                else this.rotateR();
            }
            return (maxR-minR)*(maxC-minC);
        }

    }


    public static void main(String[] args) throws IOException {
        T=Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            turtle test=new turtle(br.readLine());
            bw.write(test.result()+"\n");
        }
        bw.close();
        br.close();
    }

}
