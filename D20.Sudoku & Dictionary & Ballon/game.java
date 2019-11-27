import java.util.*;
class main{
    public static int solve(String s , Set set, String res){
        if(s.length()==0){
            System.out.println(res);
            return 1;
        }
        int count=0;
        for(int i=1;i<=s.length();i++){
            String subString = s.substring(0,i);
            if(set.contains(subString)){
                // System.out.println(subString+"\t"+s.substring(i));
                count+=solve(s.substring(i), set, res+subString+":");
            }
        }
        return count;
    }
    public static void main(String args[]){

        Set<String> set =new  HashSet<String>();
        set.add("men");
        set.add("go");
        set.add("mango");
        set.add("i");
        set.add("like");
        set.add("sam");
        set.add("samsung");
        set.add("sung");
        set.add("and");
        set.add("ilike");
        set.add("ili");
        String s = "ilikemangoandsamsung";
        solve(s, set, "");

    }
}