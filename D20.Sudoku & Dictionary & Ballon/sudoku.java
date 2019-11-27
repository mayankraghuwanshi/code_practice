import java.util.*;
class main{
    static boolean canFillThis(int arr[][] , int row , int col ,int val){
        //row check
        for(int i=0;i<arr.length;i++){
            if(arr[i][col]==val) return false;
        }
        //col check
        for(int i=0;i<arr[0].length;i++){
            if(arr[row][i]==val) return false;
        }
        //matrix check
        int r=(row/3)*3;
        int c=(col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(arr[i+r][j+c]==val) return false;
            }
        }
        return true;
    }
    static int rows[] = new int[9];
    static int cols[] = new int[9];
    static int matrix[][] = new int[9];
    static void seed(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]!=0){
                    int Mask = (1<<arr[i][j]);
                    rows[i]|=Mask;
                    cols[j]|=Mask;

                }
            }
        }
        
    }

    static boolean solveSudoku(int arr[][] , int idx){
        int rowLen = arr.length;
        int colLen = arr[0].length;
        int n=rowLen*colLen;
        if(idx==n){
            for(int ar[] : arr){
                System.out.println(Arrays.toString(ar));
            }
            return true;
        }
        int row=idx/rowLen;
        int col=idx%colLen;
        if(arr[row][col]!=0) return solveSudoku(arr, idx+1);
        else{
            for(int val=1;val<=10;val++){
                if(canFillThis(arr,row,col,val)){
                    arr[row][col]=val;
                    if(solveSudoku(arr, idx+1)) return true;
                    arr[row][col]=0;
                }
            }
        }
        return false;

    }

    public static void main(String args[]){
        int[][] arr = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0},
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        solveSudoku(arr, 0);
    }
}