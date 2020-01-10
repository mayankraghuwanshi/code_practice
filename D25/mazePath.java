import java.util.*;
class main{
    static int dp[][] = new int[100][100];
    static int mazePath(int x , int y , int xf , int yf , int dp[][]){
        if(x==xf && y==yf){
            dp[y][x]=1;
            return 1;
        }
        else if(dp[y][x]!=0){
            return dp[y][x];
        }
        int count=0;
        if(isValid(x+1,y,xf,yf)){
            count+=mazePath(x+1,y,xf,yf,dp);
        }
        if(isValid(x,y+1,xf,yf)){
            count+=mazePath(x,y+1,xf,yf,dp);
        }
        dp[y][x]=count;
        if(xf==yf){
            dp[x][y]=count;
        }
        return count;
    }
    static int mazePathMulti(int x , int y , int xf , int yf , int dp[][]){
        if(x==xf && y==yf){
            dp[y][x]=1;
            return 1;
        }
        else if(dp[y][x]!=0){
            return dp[y][x];
        }
        int count=0;
        for(int steps=1;steps<=xf;steps++){
            if(isValid(x+steps,y,xf,yf)){
                count+=mazePathMulti(x+steps,y,xf,yf,dp);
            }
        }
        for(int steps=1;steps<=yf;steps++){
            if(isValid(x,y+steps,xf,yf)){
                count+=mazePathMulti(x,y+steps,xf,yf,dp);
            }
        }
        for(int steps=1;steps<=Math.min(xf,yf);steps++){
            if(isValid(x+steps,y+steps,xf,yf)){
                count+=mazePathMulti(x+steps,y+steps,xf,yf,dp);
            }
        }
        dp[y][x]=count;
        if(xf==yf){
            dp[x][y]=count;
        }
        return count;
    }

    static void mazePathTable(int x , int y , int xf , int yf ){
        int c=1;
        // dp[0][0]=1;
        for(int i=y;i<=yf;i++){
            for(int j=x;j<=xf;j++){
                int xsum=0;
                for(int k=j;k>=x;k--){
                    xsum+=dp[i][k];
                }
                int ysum=0;
                for(int k=i;k>=y;k--){
                    ysum+=dp[k][j];
                }
                int xysum=0;
                for(int k=1;k<=Math.max(i,j);k++){
                    if(isValid(j-k,i-k,xf,yf)) xysum+=dp[i-k][j-k];
                }
                dp[i][j]=xsum+ysum+xysum+c;
                c=0;
            }
        }
        printArr();
    }
    static boolean isValid(int x , int y , int xf , int yf){
        if(x<=xf && y<=yf && x>=0 && y>=0) return true;
        return false;
    }
    static void printArr(){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(dp[i][j]!=0){
                    System.out.print(dp[i][j]+",");
                }
            }
            System.out.println();
        }
    }
    // static int minCost(int x , int y , int arr[][]){
    //     if(x==arr[0].length && y==arr.length)
    // }
    static int minCostDP(int x  , int y , int arr[][] , int dp[][] , boolean diagonal ){
        if(x==arr[0].length-1 && y==arr.length-1){
            return arr[y][x];
        }
        if(dp[y][x]!=0){
            return dp[y][x];
        }
        // System.out.println(x+"\t"+y);
        int cost=arr[y][x];
        int res=Integer.MAX_VALUE;
        if(diagonal && x+1<arr[0].length && y+1<arr.length){
            res=Math.min(res,cost+minCostDP(x+1,y+1,arr,dp,diagonal));
        }
        if(x+1<arr[0].length){
            res = Math.min(res , cost+minCostDP(x+1,y,arr,dp,diagonal));
        }
        if(y+1<arr.length){
            res=Math.min(res , cost+minCostDP(x,y+1,arr , dp,diagonal));
        }
        dp[y][x]=res;
        return res;
    }
    static int minCostTab(int x , int y , int arr[][] , boolean diagonal){
        for(int i=1;i<arr.length;i++){
            arr[i][0]+=arr[i-1][0];
        }
        for(int i=1;i<arr[0].length;i++){
            arr[0][i]+=arr[0][i-1];
        }
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++){
                if(diagonal){
                    arr[i][j]+=Math.min(Math.min(arr[i][j-1],arr[i-1][j]),arr[i-1][j-1]);
                }else{
                    arr[i][j]+=Math.min(arr[i][j-1],arr[i-1][j]);
                }
            }
        }
        printArr(arr);
        return arr[arr.length-1][arr[0].length-1];
        
    }


    static void printArr(int arr[][]){
        for(int i[] : arr){
            System.out.println(Arrays.toString(i));
        }
    }
    public static void main(String args[]){
        // System.out.println(mazePathMulti(0,0,3,3,dp));
        int arr[][] = {{1,2,5},{6,9,1},{9,2,2}};
        System.out.println(minCostTab(0,0,arr,true));
        // solve(0,0,2,2);
        printArr();
    }
}