import java.util.HashSet;
import java.util.Set;

class Solution{
    public static void mazePath(int x,int y,int xf,int yf ,String ans){
        if(x==xf && y==yf){
            System.out.println(ans);
            return;
        }

        for(int i=1;i<=xf;i++){
            if(x+i<=xf){
                mazePath(x+i,y,xf,yf,ans+i+"H");
            }
            if(y+i<=yf){
                mazePath(x,y+i,xf,yf,ans+i+"V");
            }
        }
    }

    public static void Permutation(String s , String ans){
        if(s.length()==0){
            System.out.println(ans);
            return ;
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            Permutation(new StringBuilder(s).deleteCharAt(i).toString(), ans+ch);
        }
    }

    public static void NonRepeatedPermutation(String s , String ans, Set<String> set){
        if(s.length()==0){
            if(!set.contains(ans)){
                System.out.println(ans);
                set.add(ans);
            }
            return ;
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            NonRepeatedPermutation(new StringBuilder(s).deleteCharAt(i).toString(), ans+ch,set);
        }
    }






    public static void main(String args[]){
        // mazePath(0,0,2,2,"");
        Set<String> set = new HashSet<>();
        NonRepeatedPermutation("aaa","",set);
        
    }
}