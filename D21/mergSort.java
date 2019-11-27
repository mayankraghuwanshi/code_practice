import java.util.*;
class main{
    public static int [] merge(int arr1[] , int arr2[]){
        int len1=arr1.length;
        int len2 = arr2.length;
        int i=0;
        int j=0;
        int k=0;
        int res[] = new int[len1+len2];
        while(i<len1 && j<len2){
            if(arr1[i]<arr2[j]){
                res[k]=arr1[i];
                i++;
            }
            else if(arr2[j]<arr1[i]){
                res[k]=arr2[j];
                j++;
            }
            k++;
        }
        while(j<len2){
            res[k]=arr2[j];
            j++;
            k++;
        }
        while(i<len1){
            res[k]=arr1[i];
            i++;
            j++;
        }
        return res;
    }

    static ArrayList<Integer> mergeList(ArrayList<Integer> arr1 , ArrayList<Integer> arr2){
        ArrayList<Integer> res = new ArrayList<>();
        int i=0;
        int j=0;
        int len1=arr1.size();
        int len2=arr2.size();
        while(i<len1 || j<len2){
            if(i<len1 && j<len2){
                if(arr1.get(i)<arr2.get(j)){
                    res.add(arr1.get(i));
                    i++;
                }else{
                    res.add(arr2.get(j));
                    j++;
                }
            }else if(i<len1){
                res.add(arr1.get(i));
                i++;
            }else if(j<len2){
                res.add(arr2.get(j));
                j++;
            }
        }
        return res;
    }
    static ArrayList<Integer> mergeSort(ArrayList<Integer> arr, int start , int end){
        if(start==end){
            ArrayList<Integer> res = new ArrayList<>();
            res.add(arr.get(start));
            return res;
        }
        int pivote = (end+start)/2;
        //if you fucked up pivote as 0 pivore-1 will give you overflow.
        ArrayList<Integer> ar1 = mergeSort(arr, start,pivote);
        ArrayList<Integer> ar2 = mergeSort(arr, pivote+1,end);
        return mergeList(ar1,ar2);
    }

    // static void mergeListInplace(ArrayList<Integer> arr , int i , int j , int p){

    // }
    static void placeZeroAtFirst(int arr[]){
        int z=0;

        for(int i=0;i<arr.length && z<arr.length;i++){
            if(arr[i]==0){
                int temp=arr[z];
                arr[z]=arr[i];
                arr[i]=temp;
                z++;
                
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int arr[] , int i , int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static void sortInN(int arr[]){
        int z=0;
        int t=arr.length-1;
        int i=0;
        // while(z<t  && i<=t){
        //     boolean inc=true;
        //     if(arr[i]==0){
        //         swap(arr, i, z);
        //         z++;
        //         inc=false;
        //     }
        //     if(arr[i]==2){
        //         swap(arr, i, t);
        //         t--;
        //         inc=false;
        //     }
        //     if(inc) i++;
        // }

        while(z<t  && i<=t){
            if(arr[i]==0){
                swap(arr, i, z);
                z++;
            }
            if(arr[i]==2){
                swap(arr, i, t);
                t--;
                continue;
            }
            i++;
        }

        System.out.println(Arrays.toString(arr));
    }
    public static void main(String args[]){
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1,3,5,7,9));
        // ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2,2,4,6,8,10));
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(2,1,4,3,6,4,9,8,10));
        int arr[] = {0,0,1,1,0,1,0,1,0,0};
        int arr2[] = {1,0,1,1,0,2,1,2,0,1,0,2,2};
        // placeZeroAtFirst(arr);
        sortInN(arr2);
        
        // System.out.println(mergeList(arr1,arr2));
        // System.out.println(mergeSort(arr3,0,arr3.size()-1));
    }
}