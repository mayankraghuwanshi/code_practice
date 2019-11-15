import java.util.*;
class main{
    static int map[] = new int[25];
    static String s1="send";
    static String s2="more";
    static String s3="money";
    static int toNum(int arr[] , String s){
        int res=0;
        for(int i=0;i<s.length();i++){
            int key = s.charAt(i)-'a';
            int val=map[key];
            res=res*10+val;
        }
        return res;
    }
    static boolean isValid(int arr[] , String s1 , String s2 ,String s3){
        int n1 =toNum(arr, s1);
        int n2 = toNum(arr, s2);
        int n3=toNum(arr, s3);
        System.out.println(n1+"\t"+n2+"\t"+n3);
        return (n1+n2==n3);        
    }
    
    
    static int solve(String s , int idx , boolean isDone[] , String res){
        if(idx==s.length()){
            // if(isValid(map,s1,s2,s3)){
                System.out.println(res);

                return 1;
            // }
            // return 0;
        }
        int count=0;
        for(int i=0;i<s.length();i++){
            int key = s.charAt(i)-'a';
            
        }
        return count;
    }


    public static void main(String args[]){
        String s = "demnosy";
        System.out.println(solve(s, 0, new boolean[25], ""));
    }
}