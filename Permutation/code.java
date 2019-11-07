import java.util.Arrays;

class main{
    //coint change permutation
    static int permutationWithRepetition(int arr[] , int s , int t, String str){
        int count=0;
        if(s==t){
            System.out.println(str);
            return ++count;
        }
        //explore all outcomes when repetiton is allow
        for(int i=0;i<arr.length;i++){
            if(s+arr[i]<=t) count+=permutationWithRepetition(arr, s+arr[i], t, str+" "+arr[i]);
        }
        return count;
    }


    static int permutationWithoutRepetitionWithBitMasking(int arr[] , int s , int t , String str , int selectedBit){
        int count=0;
        if(s==t){
            System.out.println(str);
            return ++count;
        }
        for(int i=0;i<arr.length;i++){
            //STEP 1.check if element at ith index is alredy used or not
            //make a mask to check ith position.
            int mask = (1<<i);
            //check if ith bit in SelectedBit is set or not. if set means we have taken that no. else we can take.

            boolean Taken = ((selectedBit&mask)==0)?false:true;
        
            if(!Taken && s+arr[i]<=t){
                //STEP 2. if not taken sofar set bit in selectedBit and sent to next recursion call.
                selectedBit = (selectedBit|mask);        //1
                count+=permutationWithoutRepetitionWithBitMasking(arr, s+arr[i], t, str+" "+arr[i], selectedBit);
                //STEP 3. after recursion call set off bit in selectedBit so that in next iteration of loop we can do same for next recursion call.
                selectedBit = (selectedBit&(~mask));    //0
            }
        }
        return count;
    }

    static int combination(int arr[] , int s, int t, String str , int vidx){
        int count=0;
        if(vidx==arr.length){
            if(s==t) System.out.println(str);
            return ++count;
        }
        if(s+arr[vidx]<=t) count+=combination(arr, s+arr[vidx], t, str+" "+arr[vidx], vidx+1);
        count+=combination(arr, s, t, str, vidx+1);
        return count;
    }


    public static void main(String args[]){
        int arr[] = new int[20];  //1 through 20.
        for(int i=0;i<20;i++) arr[i]=i+1;
        System.out.println(Arrays.toString(arr));
        int t=10;
        int s=0;
        String str="";
        int vidx=0;
        combination(arr, s, t, str,0);
    }
}