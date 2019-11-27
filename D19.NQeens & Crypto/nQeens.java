import java.util.*;
class main{
    public static int nQeenCombination(boolean arr[][] , int nQeens , int placed , int idx, String res){
        int rowLen = arr.length;
        int colLen = arr[0].length;
        int n = rowLen*colLen;
        if(idx==n){
            if(placed==nQeens){
                System.out.println(res);
                return 1;
            }
            return 0;
        }
        //Optional call.
        // if(placed==nQeens){
        //     System.out.println(res);
        //     return 1;
        // }

        int count=0;
        int row = idx/rowLen;
        int col = idx%colLen;
        if(idx+1<=n && isSafe(arr , row , col)){
        // if(idx+1<=n){
            arr[row][col]=true;
            count+=nQeenCombination(arr, nQeens, placed+1, idx+1, res+"Q"+(placed+1)+"B"+idx+" ");
            //if a recursive fun. have morethen one calls then it is a backtracing and should undo everything after one call.
            arr[row][col]=false;
        }
        return count+nQeenCombination(arr, nQeens, placed, idx+1, res);
    }



    static boolean isValidCell(boolean arr[][] , int row , int col){
        if(row>=0 && row<arr.length && col>=0 && col<arr[0].length) return true;
        return false;
    }
    static boolean isSafe(boolean arr[][] , int row , int col){
        int rows[] = {0,-1,-1,-1};
        int cols[] = {-1,0,-1,+1};
        for(int m=1;m<=arr.length;m++){
            for(int i=0;i<4;i++){    
                int newRow = row+m*rows[i];
                int newCol = col+m*cols[i];
                if(isValidCell(arr, newRow, newCol)){
                    if(arr[newRow][newCol]) return false;
                }
            }
        }
        return true;
    }




    public static void main(String args[]){
        System.out.println(nQeenCombination(new boolean[4][4], 4, 0, 0,""));
    }
}