import java.util.Map;
import java.util.HashMap;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character,Integer> map=new HashMap<>();
        int len=skill.length();
        
        for(int i=0;i<len;i++){
            char temp=skill.charAt(i);
            map.put(temp,i+1);   
        }
        
        int treeLen=skill_trees.length;
        for(int i=0;i<treeLen;i++){
            if(check(skill_trees[i],map)) {
                answer++;
                System.out.println(skill_trees[i]);
            }
        }
        return answer;
    }
    public boolean check(String string,Map<Character,Integer> map){
        int len=string.length();
        boolean isPossible=true;
        int preSkill=1;
        for(int i=0;i<len;i++){
            char temp=string.charAt(i);
            if(!map.containsKey(temp))
                continue;
            
            int cur=map.get(temp);
            if(cur!=preSkill){
                isPossible=false;
                break;
            }
            else preSkill++;
        }
        return isPossible;
    }
}