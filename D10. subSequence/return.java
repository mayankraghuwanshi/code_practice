import java.util.ArrayList;

class main{
//improve time complexity
//reduce input String    
//     static ArrayList<String> getAllSubsequence(String s , String ch){
//         if(s.length()==0){
//             ArrayList<String> res = new ArrayList<String>();
//             res.add(ch);
//             return res;
//         }
//         ArrayList<String> res = getAllSubsequence(s.substring(1), ch+s.charAt(0)+"");
//         ArrayList<String> res2 = getAllSubsequence(s.substring(1), ch);
//         for(String st:res2){
//             res.add(st);
//         }
//         return res;
// }




    static ArrayList<String> getAllSubSeq(String s){
        //base case.
        if(s.length()==0){
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        } 
        //non base case
        char ch = s.charAt(0);
        ArrayList<String > res = getAllSubSeq(s.substring(1));
        ArrayList<String> ans =new ArrayList<String>();
        ans.addAll(res);
        for(String st:res){
            ans.add(st+ch);
        } 
        return ans;
    }
    static String removeDub(String s){
        if(s.length()==1){
            return s.charAt(0)+"";
        }
        char ch = s.charAt(0);
        String s2 = removeDub(s.substring(1));
        if(ch==s2.charAt(0)){
            return s2;
        }
        return ch+s2;
    }


    // static String removeHi(String s){
    //     if(s.length()==0){
    //         return "";
    //     }



    // }

        static String hiWithoutHit(String s){
            if(s.length()==0){
                return "";
            }
            if(s.length()>1 && s.substring(0,2).equals("hi")) return hiWithoutHit(s.substring(2));
            return s.charAt(0)+hiWithoutHit(s.substring(1));
        }
        //hiihihiihih
           //^^





    public static void main(String args[]){
        // System.out.print("[");
        // for(String i:getAllSubSeq("abcd")){
        //     System.out.print("{"+i+"}"+" ");
        // }
        // System.out.print("]");
        String s = "hihihijjhihi";
        System.out.println(s.length());
        System.out.println(hiWithoutHit("hihihijjhihi").length());
    }
}