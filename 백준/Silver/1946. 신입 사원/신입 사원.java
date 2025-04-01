import java.io.*;
import java.util.*;


public class Main {

    public static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int T;
    public static int N;


    public static class Employee implements Comparable<Employee> {
        int s1,s2;
        public Employee(int s1,int s2){
            this.s1=s1;
            this.s2=s2;
        }
        @Override
        public int compareTo(Employee o) {
           return this.s1-o.s1;
        }
    }

    public static void main(String[] args) throws IOException {
        T=Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N=Integer.parseInt(br.readLine());
            Employee [] employees=new Employee[N];

            for (int j = 0; j < N; j++) {
                String []input=br.readLine().split(" ");
                employees[j]=new Employee(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
            }
            Arrays.sort(employees);
            int cut=employees[0].s2;
            int result=1;
            for (int j = 0; j < N; j++) {
                if(cut>employees[j].s2){
                    result++;
                    cut=employees[j].s2;
                }
            }
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }
}