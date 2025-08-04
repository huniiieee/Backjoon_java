import java.util.Arrays;
class Solution {
    public String[] solution(String[] files) {
        int len=files.length;
        
        Arrays.sort(files, (a,b)->extractFirstNumber(a)-extractFirstNumber(b));
        for(int i=0;i<len;i++){
            System.out.print(files[i]+" ");
        }
        Arrays.sort(files,(a,b)->extractFirstString(a).toUpperCase().compareTo(extractFirstString(b).toUpperCase()));
        System.out.println();    
        for(int i=0;i<len;i++){
            System.out.print(files[i]+" ");
        }
        return files;
    }
    
    public int extractFirstNumber(String string){
        boolean find=false;
        StringBuilder sb=new StringBuilder();
        int len=string.length();
        for(int i=0;i<len;i++){
            char temp=string.charAt(i);
            if(Character.isDigit(temp)){
                find=true;
                sb.append(temp);
            }
            else{
                if(find)
                    break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
    
    public String extractFirstString(String string){
        StringBuilder sb= new StringBuilder();
        int len=string.length();
        for(int i=0;i<len;i++){
            char temp=string.charAt(i);
            if(!Character.isDigit(temp))
                sb.append(temp);
            else 
                break;
        }
        return sb.toString();
    }
}