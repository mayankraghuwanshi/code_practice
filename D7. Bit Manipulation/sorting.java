import java.util.Arrays;

class main{
    public static int[] bubbleSort(int arr[]){
        int n=arr.length;
        int temp;
        boolean flag;
        for(int i=0;i<n;i++){
            flag=true;
            for(int j=1;j<n-i;j++){
                if(arr[j-1]>arr[j]){
                    flag=false;
                    temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
            if(flag) break;
        }
        return arr;
    }

    public static int[] selectionSort(int arr[]){
        int n=arr.length;
        int temp;
        boolean flag=false;
        for(int i=0;i<n;i++){
            flag=true;
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    flag=false;
                }
            }
            if(flag) break;
        }
        return arr;
    }

    public static void main(String args[]){
        int arr[] = {9,-8,-7,6,5,-4,3,2,1};
        //bubbleSort(arr);
        System.out.println(bubbleSort(arr).equals(selectionSort(arr)));
    }
}