class Solution{

    static int permutation(int arr[] , int s , int t , String str){
        if(s==t){
            System.out.println(str);
            return 1;
        }
        
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(s+arr[i]<=t){
                count+=permutation(arr, s+arr[i], t, str+" "+arr[i]);
            }
        }
        return count;
    }

    static int permutation2(int arr[] , int s , int t , String str , int vidx){
        if(vidx==arr.length){
            if(s==t) System.out.println(str);
            return 1;
        }
        int count =0;
        for(int i=vidx;i<arr.length;i++){
            //add current number to solution.
            if(s+arr[i]<=t) count+=permutation2(arr,s+arr[i],t,str+" "+arr[i],i+1);
            //don't add current number to solution.
            count+=permutation2(arr,s,t,str,i+1);
        }
        return count;
    }


    static int NotRepeatedPermutationBoolArray(int arr[] ,int s, int t , String str, boolean isDone[]){
        if(s==t){
            System.out.println(str);
            return 1;
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            int temp = arr[i];
            boolean flag = isDone[temp];
            if(!flag && arr[i]+s<=t){
                isDone[temp]=true;
                count+=NotRepeatedPermutationBoolArray(arr,s+arr[i],t,str+" "+arr[i],isDone);
                isDone[temp]=false;
            }
        }
        return count;
    }

    static int NotRepeatedPermutationWithMask(int arr[] ,int s, int t , String str, int bit){
        if(s==t){
            System.out.println(str);
            return 1;
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            //get element from array.
            // int temp = arr[i];
            
            int mask = (1<<i);
            int flag = (bit&mask); //isSet? flag==1 means set else not
            if(flag==0 && arr[i]+s<=t){
                bit=(bit|mask); //set to 1 and send to next recursion call.
                count+=NotRepeatedPermutationWithMask(arr,s+arr[i],t,str+" "+arr[i],bit);
                bit=(bit&(~mask)); //reset to 0 so that agle recursion me purani bit bhi set na chali jaye
            }
        }
        return count;
    }

    static void combination(int arr[] ,int i, int s , int t, String str){
        if(i==arr.length){
            if(s==t) System.out.println(str);
            return ;
        }
        if(s==t){
            System.out.println(str);
            return;
        }
        combination(arr,i+1, s+arr[i], t, str+" "+arr[i]);
        combination(arr,i+1, s, t, str);


    }


    static void equiSet(int arr[] , int s1,int s2,String set1,String set2,int vidx){
        // System.out.println(set1+set2);
        if(s1==s2 && s1!=0){
            System.out.println(set1+" = "+set2);
        }
        if(vidx<arr.length){
            equiSet(arr, s1+arr[vidx], s2, set1+arr[vidx], set2, vidx+1);
            equiSet(arr, s1, s2+arr[vidx], set1, set2+arr[vidx], vidx+1);
        }
    }




    

    public static void main(String args[]){
        int arr[] = {10,20,30,40,50,60,70,80,90};
        boolean isDone[] = new boolean[100];
        NotRepeatedPermutationWithMask(arr, 0,100,"",0);
        // permutation2(arr, 0, 100, "",0);
    }
}