import java.util.*;
class main{

    static int arr[] = new int[26];
    
    static void initializeArray(){
        Arrays.fill(arr, -1);
    }
    static int getStringToNum(String s){
        int res=0;
        for(int i=0;i<s.length();i++){
            int key = s.charAt(i)-'a';
            res=res*10+arr[key];
        }
        return res;
    }

    static boolean isValid(String s1 , String s2 , String s3){
        int n1=getStringToNum(s1);
        int n2=getStringToNum(s2);
        int n3=getStringToNum(s3);
        return (n1+n2==n3);
    }

    static int solve(String s,int split1,int split2, int idx, int bit, String res){
        if(idx==s.length()){
            if(isValid(s.substring(0,split1),s.substring(split1,split2),s.substring(split2))){System.out.println(res);
                return 1;
            }
            return 0;
        }
        int count=0;
        char ch = s.charAt(idx);
        int key = ch-'a';
        //if character has never assigned.
        if(arr[key]==-1){
            for(int i=0;i<10;i++){
                int Mask = (1<<i);
                if((bit&Mask)==0){
                    bit=bit|Mask;
                    arr[key]=i;
                    count+=solve(s,split1,split2,idx+1,bit,res+ch+":"+i+" ");
                    bit=(bit&(~Mask));
                    arr[key]=-1;
                }
            }
        }
        else{
            count+=solve(s,split1,split2, idx+1, bit, res);
        }
        return count;        
    }
    public static void main(String args[]){
        String s1 = "send";
        String s2 = "more";
        String s3 = "money";
        String s=s1+s2+s3;
        initializeArray();
        // System.out.println(Arrays.toString(arr));
        System.out.println(solve(s,4,8,0,0,""));
    }
}