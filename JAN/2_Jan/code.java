
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
       int n = words.length;
       int[] prefix = new int[n];
       int[] individual = new int[n];
       Set<Character> set = new HashSet<>();
       set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');

       prefix[0] = (set.contains(words[0].charAt(0)) && set.contains(words[0].charAt(words[0].length()-1))) ? 1 : 0;
       individual[0] = prefix[0];


       for(int i = 1 ; i < n ; i++){
         String str = words[i];
          if(set.contains(str.charAt(0)) && set.contains(str.charAt(str.length()-1)) ){
            individual[i] = 1;
            prefix[i] = prefix[i-1] + 1 ;
            
          }else{
            individual[i] = 0;
            prefix[i] = prefix[i-1];
          }
       }

       int[] ans = new int[queries.length];

       for(int i = 0 ; i < queries.length ; i++){
            int start = queries[i][0];
            int end  = queries[i][1];
            if(start == 0){
                ans[i] = prefix[end];
                continue;
            }
            if(start == end){
                ans[i] = individual[end];
            }
            else{
                ans[i] = prefix[end] - prefix[start-1];
            }
       } 
       return ans;
    }
}