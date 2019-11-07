import java.util.ArrayList;
import java.util.Arrays;

class main{
    static boolean isValid(int x,int y,boolean isDone[][]){
        if((x<isDone[0].length) && (y<isDone.length) && (x>=0) && (y>=0) && !isDone[y][x]) return true;
        return false;
    }

    //working.
    static ArrayList<String> knightMoveInMaze(int x , int y , int xf , int yf , boolean isDone[][]){
        ArrayList<String> res = new ArrayList<>();
        if(x==xf && y==yf){
            res.add("");
            return res;
        }
        isDone[y][x]=true;
        for(boolean b[] : isDone){
            System.out.println(Arrays.toString(b));
        }
        System.out.println();
        int arr[][] = {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
        String move[] = {"2X1Y","1X2Y","-1X2Y","-2X1Y","-1X-2Y","1X-2Y","2X-1Y","8"};
        for(int i=0;i<arr.length;i++){
            int X = x+arr[i][0];
            int Y = y+arr[i][1];
            if(isValid(X,Y,isDone)){
                // System.out.println("yeah");
                ArrayList<String> rec = knightMoveInMaze(X, Y, xf, yf, isDone);
                for(String s : rec){
                    res.add(move[i]+s);
                }
                
            }
        }
        isDone[y][x]=false;
        return res;
      }

      //working.
      static ArrayList<String> floodFill(int x , int y , int xf , int yf , boolean isDone[][]){
        ArrayList<String> res = new ArrayList<>();
        if(x==xf && y==yf){
            System.out.println("got a path :)");
            res.add("");
            return res;
        }
        isDone[y][x]=true;
        for(boolean b[] : isDone){
            System.out.println(Arrays.toString(b));
        }
        System.out.println();
        int arr[][] = {{0,-1},{1,0},{0,1},{-1,0}};
        String move[] = {"X-1Y","1XY","X1Y","-1XY"};
        for(int i=0;i<arr.length;i++){
            int X = x+arr[i][0];
            int Y = y+arr[i][1];
            if(isValid(X,Y,isDone)){
                ArrayList<String> rec = floodFill(X, Y, xf, yf, isDone);
                for(String s : rec){
                    res.add(move[i]+s);
                }
                
            }
        }
        isDone[y][x]=false;
        return res;
      }

      
      //working
      static boolean knightMoves(int x,int y , int current , int size , boolean isDone[][] , int temp[][]){
        isDone[y][x]=true;
        
        temp[y][x]=current;
        // for(int ar[]:temp){
        //         System.out.println(Arrays.toString(ar));
        //     }
        //     System.out.println();

        if(current==size-1){
            for(int ar[]:temp){
                System.out.println(Arrays.toString(ar));
            }
            return true;
        }
        

        int arr[][] = {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
        // boolean res=false;
        // for(int i=0;i<arr.length &&(!res);i++){
        //     int X = x+arr[i][0];
        //     int Y = y+arr[i][1];
        //     if(isValid(X, Y, isDone)){
        //         boolean val = knightMoves(X, Y, current+1, size, isDone, temp);
        //         res = res || val;
        //     }
        // }

        boolean res=false;
        for(int i=0;i<arr.length && (!res);i++){
            int X = x+arr[i][0];
            int Y = y+arr[i][1];
            if(isValid(X, Y, isDone)){
                res = knightMoves(X, Y, current+1, size, isDone, temp);
            }
        }  
        
        isDone[y][x]=false;
        temp[y][x]=0;
        return res;
    }

    // output-
        // [0, 13, 18, 7, 24]
        // [5, 8, 1, 12, 17]
        // [14, 19, 6, 23, 2]
        // [9, 4, 21, 16, 11]
        // [20, 15, 10, 3, 22]







       





    static ArrayList<String> getKeys01(String s , String keys[]){
        ArrayList<String> res = new ArrayList<String>();
        if(s.length()==0){
            res.add("");
            return res;
        }
        int index = Integer.parseInt(s.charAt(0)+"");
        // System.out.println(index);
        ArrayList<String> rec = getKeys01(s.substring(1),keys);
        String key = keys[index];
        for(int i=0;i<key.length();i++){
            for(String st : rec){
                res.add(key.charAt(i)+st);
            }
        }
        return res;
    }
    public static void main(String args[]){
        int xf=5;
        int yf=5;
        boolean arr[][] = new boolean[yf][xf];
        int temp[][] = new int[yf][xf];
        
        knightMoves(0, 0, 0,xf*yf , arr,temp);
        
        
    }
}