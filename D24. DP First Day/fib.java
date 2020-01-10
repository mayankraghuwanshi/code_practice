import java.util.*;

class main{
    static int dp[] = new int[100];
    static int boardPath(int src){
        if(src==0) return 1;
        else if(dp[src]!=0) return dp[src];
        int count=0;
        for(int i=1;i<=6;i++){
            if(src-i>=0){
                count+=boardPath(src-i);
            }
        }
        dp[src]=count;
        return count;
    }
    static int [][] pow(int arr[][] , int n){
        if(n==0){
            int temp[][]= {{1,0},{0,1}};
            return temp;
        }
        else if(n==1) return arr;
        else if(n%2==0){
            int temp[][] = pow(arr,n/2);
            int res[][] = new int[2][2];
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){   
                    for(int k=0;k<2;k++){
                        res[i][j]+=temp[i][k]*temp[k][j];
                    }
                }
            }
            return res;
        }
        int temp[][] = pow(arr,n-1);
            int res[][] = new int[2][2];
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    for(int k=0;k<2;k++){
                        res[i][j]+=arr[i][k]*temp[k][j];
                    }
                }
            }
        return res;
    }
    static int boardPathTab(int src){
        int arr[] = new int[src+1];
        int cum=0;
        for(int i=1;i<arr.length;i++){
            // cum++;
            if(i-6>=0){
                arr[i]=cum+1-arr[i-6];
            }else{
                arr[i]=cum+1;
            }
            cum+=arr[i];
        }
        // System.out.println(Arrays.toString(arr));
        return arr[src];
    }
    static int mazePath1(int x , int y , int xf , int yf, int dp[][]){
        if(x==xf && y==yf){
            return 1;
        }
        else if(dp[y][x]!=0) return dp[y][x];
        int count=0;
        if(isValid(x+1,y,xf,yf)){
            count+=mazePath1(x+1,y,xf,yf,dp);
        }
        if(isValid(x,y+1,xf,yf)){
            count+=mazePath1(x,y+1,xf,yf,dp);
        }
        dp[y][x]=count;
        dp[y][x]=count;
        return count;
    }

    static int mazePath2(int x , int y , int xf , int yf, int dp[][]){
        if(x==xf && y==yf){
            return 1;
        }
        else if(dp[yf-y][xf-x]!=0) return dp[y][x];
        int count=0;
        if(isValid(x+1,y,xf,yf)){
            count+=mazePath2(x+1,y,xf,yf,dp);
        }
        if(isValid(x,y+1,xf,yf)){
            count+=mazePath2(x,y+1,xf,yf,dp);
        }
        if(isValid(x+1,y+1,xf,yf)){
            count+=mazePath2(x+1,y+1,xf,yf,dp);
        }
        dp[yf-y][xf-x]=count;
        return count;
    }
    // static int mazePathZump(int x , int y , int xf , int yf , int dp , boolean isDone[][]){

    // }
    static boolean isValid(int x , int y , int xf , int yf){
        if(x<=xf && y<=yf) return true;
        return false;
    }
    static void printFib(int n){
        int arr[][] = {{1,1},{1,0}};
        int temp[][] = pow(arr,n);
        System.out.println(temp[1][0]);
    }
    static void print(int arr[][]){
        for(int i[] : arr){
            System.out.println(Arrays.toString(i));
        }
    }
    public static void main(String args[]){
        int dp[][] = new int[6][6];
        
       System.out.println(mazePath1(0,0,5,5,dp,level));
    //    print(dp);
    System.out.println(level);

    }
}