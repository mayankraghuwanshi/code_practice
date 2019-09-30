import java.util.Arrays;

class main{
    public static int[] rotate2(int arr[],int r){
        r=r%arr.length;
        if(r<0){
            r=arr.length+r;
        }
        int arr2[] = new int[arr.length];
        int k=0;
        for(int i=r;i<arr.length;i++){
            arr2[k]=arr[i];
            k++;
        }
        for(int i=0;i<r;i++){
            arr2[k]=arr[i];
            k++;
        }
        return arr2;
        
    }
    public static void rotate(int arr[], int r){
        reverse(arr, 0, r-1);
        reverse(arr, r, arr.length-1);
        reverse(arr, 0, arr.length-1);
    }
    public static void display(int arr[]){
        for(int i:arr) System.out.print(i+" ");
        System.out.println();
    }
    public static void reverse(int arr[] , int start,int end){
        int temp=0;
        while(start<end){
            temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,7};
        
        display(arr);
        //reverse(arr, 0, 4);
        //System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(reverse(arr, 0, 3)));
        arr = rotate2(arr,-2);
        display(arr);
    }
}