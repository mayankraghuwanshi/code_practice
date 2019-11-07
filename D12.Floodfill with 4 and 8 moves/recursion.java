import java.util.ArrayList;

class main{
    static boolean isValid(int x,int y,boolean [][]isDone, int [][] path){
        if(x>=0 && x<path[0].length && y>=0 && y<path.length && !isDone[y][x] && path[y][x]!=1 ) return true;
        return false;
    }

    //with 4 moves with obstracle
    static ArrayList<String> floofFillWith4Moves(int x,int y,boolean isDone[][] , int path[][] ){
        ArrayList<String> res = new ArrayList<>();
        if(x==path[0].length-1 && y==path.length-1){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        isDone[y][x]=true;
        //up move
        if(isValid(x, y-1, isDone, path)){
            ArrayList<String> rec = floofFillWith4Moves(x, y-1, isDone, path);
            for(String s:rec){
                res.add("U "+s);
            }
        }
        
        //right move
        if(isValid(x+1, y, isDone, path)){
            ArrayList<String> rec = floofFillWith4Moves(x+1, y, isDone , path);
            for(String s:rec){
                res.add("R "+s);
            }
        }

        //down move
        if(isValid(x, y+1, isDone, path)){
            ArrayList<String> rec = floofFillWith4Moves(x, y+1,  isDone,path);
            for(String s:rec){
                res.add("D "+s);
            }
        }
        


        //left move
        if(isValid(x-1, y, isDone, path)){
            ArrayList<String> rec = floofFillWith4Moves(x-1, y, isDone , path);
            for(String s:rec){
                res.add("L "+s);
            }
        }

       isDone[y][x]=false;
       return res;
    }
    
    //working.
    static ArrayList<String> floodFillWith8Moves(int x,int y,int path[][] , boolean isDone[][]){
        ArrayList<String> res = new ArrayList<>();
        if(x==path[0].length-1 && y==path.length-1){
            res.add("");
            return res;
        }
        
        isDone[y][x]=true;

        //(x,y)
        int moves[][] = {{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1}};
        String names[] = {"U","ur","R","rd","D","dl","L","lu"};
        for(int i=0;i<moves.length;i++){
            int X =x + moves[i][0];
            int Y =y + moves[i][1];
            if(isValid(X, Y, isDone, path)){
                ArrayList<String> rec = floodFillWith8Moves(X, Y, path, isDone);
                for(String s : rec){
                    res.add(names[i]+s);
                }
            }
        }
        
        isDone[y][x]=false;
        return res;
    }



    public static void main(String args[]){
        int path[][] = {{0,0,0},{0,0,0},{0,0,0}};
        boolean isDone[][] = new boolean[3][3];
        ArrayList<String> res = floodFillWith8Moves(0,0,path,isDone);
        for(String s:res){
            System.out.println(s);
        }
    }
}