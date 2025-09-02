class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            int temp=arr1[i]|arr2[i];
            String binary=Integer.toBinaryString(temp);
            binary= binary.replace("1","#");
            binary=binary.replace("0"," ");
            while(binary.length()!=n){
                binary=" "+binary;
            }
            answer[i]=binary;
        }
        return answer;
    }
}