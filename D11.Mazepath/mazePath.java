import java.util.ArrayList;
class main{
    //pending work- string compression.

    //maze path with right down and diagonal(right bottom) move.
    static ArrayList<String> mazePath(int sr,int sc , int er , int ec ){
       ArrayList<String> res = new ArrayList<>();
       if(sc==ec && sr==er){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
       }
       if(sc+1<=ec){
            ArrayList<String> horizontalMove = mazePath(sr, sc+1, er, ec);
            for(String s:horizontalMove){
                res.add("H"+s);
            }
        }
        
       if(sc+1<=ec && sr+1<=er){
        ArrayList<String> diagonalMove = mazePath(sr+1, sc+1, er, ec);
        for(String s:diagonalMove){
            res.add("D"+s);
        }
        }
        if(sr+1<=er){
            ArrayList<String> verticalMove = mazePath(sr+1, sc, er, ec);
            for(String s:verticalMove){
                res.add("V"+s);
            }
        }
        return res;
    }

    static ArrayList<String> mazePath2(int sr,int sc , int er , int ec ){
        ArrayList<String> res = new ArrayList<>();
        //base case.
        if(sc==ec && sr==er){
             ArrayList<String> base = new ArrayList<>();
             base.add("");
             return base;
        }
        //horizontal
        if(sc+1<=ec){
             ArrayList<String> horizontalMove = mazePath(sr, sc+1, er, ec);
             for(String s:horizontalMove){
                 res.add("H"+s);
             }
         }
         //diagonal
        if(sc+1<=ec && sr+1<=er){
            ArrayList<String> diagonalMove = mazePath(sr+1, sc+1, er, ec);
            for(String s:diagonalMove){
                res.add("D"+s);
            }
         }
         //vertical
         if(sr+1<=er){
             ArrayList<String> verticalMove = mazePath(sr+1, sc, er, ec);
             for(String s:verticalMove){
                 res.add("V"+s);
             }
         }
         return res;
     }

     static ArrayList<String> mazePath3(int sr,int sc , int er , int ec ){
        ArrayList<String> res = new ArrayList<>();
        if(sc==ec && sr==er){
             ArrayList<String> base = new ArrayList<>();
             base.add("");
             return base;
        }
       
        //n moves vertical
         for(int i=1;i<=er;i++){
             if((sr+i)<=er){
                ArrayList<String> verticalMove = mazePath(sr+i, sc, er, ec);
                for(String s:verticalMove){
                    res.add("V"+i+s);
                }
             }
         }
         //n moves horizontal
         for(int i=1;i<=ec;i++){
            if((sc+i)<=ec){
               ArrayList<String> horizontalMove = mazePath(sr, sc+i, er, ec);
               for(String s:horizontalMove){
                   res.add("H"+i+s);
               }
            }
        }
        //n moves diagonal
        for(int i=1;i<=Math.min(ec,er);i++){
            if((sc+i)<=ec && (sr+i)<=er){
               ArrayList<String> diagonalMove = mazePath(sr+i, sc+i, er, ec);
               for(String s:diagonalMove){
                   res.add("D"+i+s);
               }
            }
        }
        
         return res;
     }

     static int getHeightOfNMazePath(int x,int y,int xf,int yf){
        int height=0; 
        if(x==xf && y==yf){
             return ++height;
         }
         if(x+1<=xf){
             height=Math.max(1+getHeightOfNMazePath(x+1, y, xf, yf),height);
         }
         if(y+1<=yf){
             height=Math.max(1+getHeightOfNMazePath(x, y+1, xf, yf),height);
         }
         if(x+1<=xf && y+1<=yf){
             height=Math.max(1+getHeightOfNMazePath(x+1, y+1, xf, yf),height);
         }
         return height;
     }



     

 




    public static void main(String args[]) {
      System.out.println(getHeightOfNMazePath(0,0,5,5));
        for(String s : mazePath(0,0,5,5)){
          System.out.println(s);
      }
    }
}