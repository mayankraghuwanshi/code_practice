import java.util.Arrays;

class main{
    static int[] getAllIndex(int arr[] , int i, int item,int size){
        if(i==arr.length){
            return new int[size];

        }
        boolean flag = false;
        if(arr[i]==item){
            size++;
            flag=true;
        }
        int temp[] =  getAllIndex(arr, ++i, item, size);
        if(flag) temp[size-1]=i;
        return temp;
    }
    static int jumps(int arr[] , int index){
        if(index==arr.length){
            return 1;
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(!(index+arr[i]>arr.length)){
                count+=jumps(arr, index+arr[i]);
            }
        }
        return count;
    }

    public static void main(String args[]){
        int arr[] = {1,2,3};
        System.out.println(jumps(arr, 0));
    }
}