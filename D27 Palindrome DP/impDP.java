import java.util.*;
class main{
    public static void palindromicSubString(String s){
        int len = s.length();
        boolean table[][] = new boolean[len][len];
        for(int dig=0;dig<len;dig++){
            int i=0;
            int j=dig;
            while(j<len){
                if(dig==0){
                    table[i][j]=true;
                }else if(dig==1 && s.charAt(i)==s.charAt(j)){
                    table[i][j]=true;
                }else if(s.charAt(i)==s.charAt(j) && table[i+1][j-1]){
                    table[i][j]=true;
                }
                i++;
                j++;
            }
        }
        // for(boolean i[] : table){
        //     System.out.println(Arrays.toString(i));
        // }
        int dp[][] = new int[len][len];
        for(int dig=0;dig<len;dig++){
            int i=0;
            int j=dig;
            while(j<len){
               if(dig==0){
                    dp[i][j]=1;
                }else if(dig==1 && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=2;
                }else if(s.charAt(i)==s.charAt(j) && table[i+1][j-1]){
                    dp[i][j]=dp[i+1][j-1]+2;
                // }else{
                //     //by enabling this comment you can get max. length of palindromic substring at dp[0][len-1];
                //     dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                // }
                i++;
                j++;
            }
        }
        for(int i[] : dp){
            System.out.println(Arrays.toString(i));
        }
        // for(int i=0;i<len;i++){
        //     for(int j=i;j<len;j++){
        //         if(dp[i][j]>0){
        //             System.out.println(s.substring(i,j+1));
        //         }
        //     }
        // }
    }
    static void palindromicSubSequence(String s){
        int len = s.length();
        int dp[][] = new int[len][len];
        for(int dig=0;dig<len;dig++){
            int i=0;
            int j=dig;
            while(j<len){
                if(dig==0){
                    dp[i][j]=1;
                }
                else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        for(int i[] : dp){
            
        }

    }
    public static void main(String args[]){
        solve("abcba");
    }
}
