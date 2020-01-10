import java.util.*;
class main{
    static int getPalindromicLength(int i,String s){
        int res=1;
        int left=i-1;
        int right = i+1;
        while(left>=0 && right<s.length()){
            if(s.charAt(left)==s.charAt(right)){
                res+=2;
            }else break;
            left--;
            right++;

        }
        return res;
    }
    static int getPalindromicLength(int i , int j , String s){
        int res=0;
        while(i>=0 && j<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                res+=2;
            }else break;
            i--;
            j++;
        }
        return res;
    }
    static int getLengthOfLongestPalindromicSubString(String s){
        int res=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            res=Math.max(res,Math.max(getPalindromicLength(i,s),getPalindromicLength(i,i+1,s)));
        }
        return res;
    }
    static String getPalindromicSubString(int i , String s){
        int left=i;
        int right=i;
        while(left>=0 && right<s.length()){
            if(s.charAt(left)!=s.charAt(right)) break;
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
    static String getPalindromicSubString(int i ,int j, String s){
        int left=i;
        int right=j;
        while(left>=0 && right<s.length()){
            if(s.charAt(left)!=s.charAt(right)) break;
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
    static String  getLongestPalindromicSubString(String s){
        String res="";
        for(int i=0;i<s.length();i++){
            String s1=getPalindromicSubString(i,s);
            String s2=getPalindromicSubString(i,i+1,s);
            if(s1.length()>=s2.length() && s1.length()>=res.length()){
                res=s1;
            }else if(s2.length()>=s1.length() && s2.length()>=res.length()){
                res=s2;
            }
        }
        return res;
    }
    static boolean isPalindrome(String s){
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    static String subSequence(String s , String res){
        if(s.length()==0){
            if(isPalindrome(res)){
                return res;
            }
            return "";
        }
        char ch=s.charAt(0);
        String s1=subSequence(s.substring(1),res+ch);
        String s2=subSequence(s.substring(1),res);
        return s1.length()>s2.length()?s1:s2;        
    }

    public static void main(String args[]){
        String s = "ababa";
        System.out.println(subSequence(s,""));
    }
}