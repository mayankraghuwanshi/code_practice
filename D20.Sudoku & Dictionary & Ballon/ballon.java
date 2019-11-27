import java.util.*;
class main{
   static int solve(ArrayList<Integer> arr , int c){
       if(arr.size()==0){
           return c;
       }
       int max=Integer.MIN_VALUE;
       for(int i=0;i<arr.size();i++){
            int step=getVal(arr, i);
            int val=arr.get(i);
            arr.remove(i);
            int rec = solve(arr, c+step);
            max=Math.max(rec, max);
            arr.add(i,val);
       }
       return max;
   }
   static int getVal(ArrayList<Integer> arr , int idx){
       if(arr.size()==1) return arr.get(0);
       if(idx==0){
           int res=0;
           res = arr.get(idx)*arr.get(idx+1);
           return res;
       }
       if(idx==arr.size()-1){
           int res=0;
           res = arr.get(idx)*arr.get(idx-1);
           return res;
       }
       int res=0;
       res=arr.get(idx-1)*arr.get(idx)*arr.get(idx+1);
       return res;
   }
    public static void main(String args[]){
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        System.out.println(solve(arr, 0));
    }
}