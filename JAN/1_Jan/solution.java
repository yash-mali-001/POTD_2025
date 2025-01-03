class solution {
    // public int count(String s , char num){
    //     int ans = 0;
    //     for(int i = 0 ; i < s.length() ; i++){
    //         if(s.charAt(i) == num){
    //             ans++;
    //         }
    //     }
    //     return ans;
    // }
    public int maxScore(String s) {
        // int max = Integer.MIN_VALUE;
        // for(int i = 1 ; i < s.length() ; i++){
        //     String left = s.substring(0 , i);
        //     String right = s.substring(i);
        //     int ans = count(left,'0') + count(right,'1');
        //     if(ans > max){
        //         max = ans;
        //     } 
        // }
        // return max;

        int n = s.length();
        int totalOnes = 0;

        for(char ch : s.toCharArray()){
            if(ch == '1'){
                totalOnes++;
            }
        }

        int max = Integer.MIN_VALUE;
        int leftZeroes = 0 , leftOnes =0;

        for(int i = 0 ; i < n-1 ; i++){
            if(s.charAt(i) == '0'){
                leftZeroes++;
            }else{
                leftOnes++;
            }
            
            int count = leftZeroes + (totalOnes - leftOnes);
            max = Math.max(count , max);
        }

        return max;
    }
}