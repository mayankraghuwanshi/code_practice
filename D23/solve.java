import java.util.*;
class main{
    public static void floodFill(int x , int y ,int arr[][],boolean isDone[][]){
        if(isValid(x,y,arr) && arr[y][x]==0){
            return;
        }
        // isDone[y][x]=true;
        arr[y][x]=0;
        int newX[] = {1,0,-1,0};
        int newY[] = {0,-1,0,1};
        for(int i=0;i<4;i++){
            int X = x+newX[i];
            int Y = y+newY[i];
            if(isValid(x,y,arr) && !isDone[Y][X]){
                isDone[Y][X]=true;
                floodFill(X,Y,arr,isDone);
                isDone[Y][X]=false;
            }
        }

    }
    static boolean isValid(int x , int y , int arr[][]){
        if(x<arr[0].length && x>=0 && y>=0 && y<arr.length) return true;
        return false;
    }
    public static void main(String args[]){
        int arr[][] = {{0,1,0},{1,1,0},{1,0,0}};
        int test[][]={{1,1}};
        boolean isDone[][] = new boolean[3][3];
        floodFill(1,1,arr,isDone);
        System.out.println(Arrays.toString(arr));

    }
}