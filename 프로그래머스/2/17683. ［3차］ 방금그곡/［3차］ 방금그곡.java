import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m=m.replace("A#","H").replace("B#","I").replace("C#","J").replace("D#","K")
                    .replace("F#","M").replace("G#","N");
        int len=musicinfos.length;
        int max=0;
        for(int i=0;i<len;i++){
            String melody=fullMelody(musicinfos[i]);
            if(melody.contains(m)){
                if(max<melody.length()){
                    max=melody.length();
                    answer=musicinfos[i].split(",")[2];
                }
            }
        }
        return answer;
    }
    
    public String fullMelody(String musicinfo){
        String [] temp= musicinfo.split(",");
        int end= Integer.parseInt(temp[1].split(":")[0])*60+Integer.parseInt(temp[1].split(":")[1]);
        int start= Integer.parseInt(temp[0].split(":")[0])*60+Integer.parseInt(temp[0].split(":")[1]);
        int m=end-start;
        
    
        String melody=temp[3];
        melody=melody.replace("A#","H").replace("B#","I").replace("C#","J").replace("D#","K").replace("F#","M").replace("G#","N");
        int len = melody.length();
        int q=m/len;
        int r=m%len;
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<q;i++){
            sb.append(melody);
        }
        sb.append(melody.substring(0,r));
        
        return sb.toString();
    }
}