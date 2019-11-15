import java.util.Vector;

class main{
    static void getPermutation(int arr[] , int idx ,int t, String s){
        if(idx==arr.length){
            if(t==0) System.out.println(s);
            return;
        }
        int item = arr[idx];
        if(t-item>=0) getPermutation(arr, 0, t-item, s+" "+item);
        getPermutation(arr, idx+1, t, s);
    }
    static int placeQeen(int boardSize , int nQeen, int placed , int idx , String s){
        if(idx==boardSize){
            if(placed==nQeen) System.out.println(s);
        return 1;
        }
        int count=0;
        count+=placeQeen(boardSize,nQeen,placed,idx+1,s);
        int newPlaced=placed+1;
        return count+placeQeen(boardSize,nQeen,newPlaced,idx+1,s+" "+"B"+idx+"Q"+newPlaced);
    }

    static int placeQeenCombination(int boardSize , int nQeen, int placed , int idx , String s){
       
        if(placed==nQeen) {
            System.out.println(s);
            return 1;
        }
        int count=0;
        for(int i=idx;i<=boardSize;i++){
            count+=placeQeenCombination(boardSize, nQeen, placed+1, i+1, s+"B"+i+"Q"+(placed+1)+" ");
        }
        return count;
    }

    static int placeQeenPermutation(boolean board[] , int nQeen , int placed , int idx , String s){
        if(placed==nQeen) {
            System.out.println(s);
            return 1;
        }
        int count=0;
        for(int i=0;i<board.length;i++){
            if(!board[i]){
                board[i]=true;
                count+=placeQeenPermutation(board, nQeen, placed+1, i+1, s+"B"+(i+1)+"Q"+(placed+1)+" ");
                board[i]=false;
            }
            
        }
        return count;
    }

    static int placeQeenCombinationSubMethod(int board,int nQeens,int placed , int idx , String s){
        if(placed==nQeens){
            System.out.println(s);
            return 1;
        }
        int count=0;
        if(idx+1<=board){
            count+=placeQeenCombinationSubMethod(board, nQeens, placed+1, idx+1, s+"B"+idx+"Q"+(placed+1)+" ");
            count+=placeQeenCombinationSubMethod(board, nQeens, placed, idx+1, s);
        }
        return count;
    }
    
    static int placeQeenPermutationSubMethod(boolean board[],int nQeens,int placed , int idx , String s){
        if(placed==nQeens){
            System.out.println(s);
            return 1;
        }
        int count=0;
        if(idx+1<=board.length){
            if(!board[idx]){
                board[idx]=true;
                count+=placeQeenPermutationSubMethod(board, nQeens, placed+1, 0, s+"B"+idx+"Q"+(placed+1)+" ");
                board[idx]=false;
            }
            
            count+=placeQeenPermutationSubMethod(board, nQeens, placed, idx+1, s);
        }
        return count;
    }

   static int placeQeenCombIn2D(boolean box[][] , int nQeens , int placed , int idx , String res){
       if(placed==nQeens){
           System.out.println(res);
           return 1;
       }
       if(idx>box.length*box[0].length) return 0;
       int count=0;
       for(int i=idx;i<box.length*box[0].length;i++){
            count+=placeQeenCombIn2D(box, nQeens, placed+1, i+1, res+"B"+idx+"Q"+(placed+1)+" ");
       }
       return count;
   }
   
   static int placeQeenPermutationIn2D(boolean box[][] , int nQeens , int placed , int idx , String res){
        if(placed==nQeens){
            System.out.println(res);
            return 1;
        }
        if(idx==box.length*box[0].length) return 0;
        int count=0;
        for(int i=0;i<box.length*box[0].length;i++){
            if(!box[idx/box.length][idx%box.length]){
                box[idx/box.length][idx%box.length]=true;
                count+=placeQeenPermutationIn2D(box, nQeens, placed+1, i+1, res+"B"+idx+"Q"+(placed+1)+" ");
                box[idx/box.length][idx%box.length]=false;
            }
            
        }
        return count;
    }

    static int placeQeenCombIn2DWithSubMethod(boolean box[][] , int nQeens , int placed , int idx , String res){
        if(placed==nQeens){
            System.out.println(res);
            return 1;
        }
        if(idx>=box.length*box.length) return 0;
        int count=0;
        if(idx+1<=box.length*box.length){
            count+=placeQeenCombIn2DWithSubMethod(box,nQeens,placed+1,idx+1,res+"B"+idx+"Q"+(placed+1));
            count+=placeQeenCombIn2DWithSubMethod(box, nQeens, placed, idx+1, res);
        }
        return count;
    }
    static int placeQeenPermutation2DWithSubMethod(boolean box[][] , int nQeens , int placed , int idx , String res){
        if(placed==nQeens){
            System.out.println(res);
            return 1;
        }
        if(idx>=box.length*box.length) return 0;
        int count=0;
        if(idx+1<=box.length*box.length){
            if(!box[idx/box.length][idx%box.length]){
                box[idx/box.length][idx%box.length]=true;
                count+=placeQeenPermutation2DWithSubMethod(box,nQeens,placed+1,0,res+"B"+idx+"Q"+(placed+1));
                box[idx/box.length][idx%box.length]=false;
            }
            count+=placeQeenPermutation2DWithSubMethod(box, nQeens, placed, idx+1, res);
        }
        return count;
    }


      

    public static void main(String args[]){
        // System.out.println(placeQeenPermutationSubMethod(new boolean[7], 3, 0, 0, ""));
        int n=2;
        boolean arr[][] = new boolean[n][n];
        
    }
}