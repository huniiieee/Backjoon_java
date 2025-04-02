import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int N;


    public static class Employee implements Comparable<Employee> {
        int s1,s2;
        public Employee(int s1,int s2){
            this.s1=s1;
            this.s2=s2;
        }
        @Override
        public int compareTo(Employee o) {
           if(this.s1>o.s1&&this.s2>o.s2){
               return 1;
           }
           else if((this.s1-o.s1)*(this.s2-o.s2)<=0){
               return 0;
           }
           else return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        N=Integer.parseInt(br.readLine());
        Employee [] employees= new Employee[N];
        for (int i = 0; i < N; i++) {
            String []input=br.readLine().split(" ");
            employees[i]=new Employee(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }

        for (int i = 0; i < N; i++) {
            int cnt=0;
            for (int j = 0; j < N; j++) {
                if(employees[i].compareTo(employees[j])<0)
                    cnt++;
            }
            bw.write((cnt+1)+" ");
        }
        bw.flush();
        bw.close();
    }
}