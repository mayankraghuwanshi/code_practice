import java.util.Arrays;
import java.util.Scanner;

class main{
    public static final Scanner scn = new Scanner(System.in);
    
    public static void pattern1(int n){
        int nst = 1;                        //number of spaces in first row.
        int nsp = n-1;                      //number of stars in first row
        for(int i=1;i<=n;i++){
            for(int csp=1; csp<=nsp;csp++){
                System.out.print(" ");
            }
            for(int cst=1;cst<=nst;cst++){
                System.out.print("*");
            }
            nsp--;
            nst++;
            System.out.println();
        }
    }
//OUTPUT    
//        *
//       **
//      ***
//     ****
//    *****
//   ******
//  *******

    

    public static void pattern2(int n){
        int nst=1;
        int nsp=n-1;
        for(int i=1;i<=n;i++){
            for(int csp=1;csp<=nsp;csp++){
                System.out.print(" ");
            }
            for(int cst=1;cst<=nst;cst++){
                System.out.print("*");
            }
            System.out.println();
            nsp--;
            nst+=2;
        }
    }
//OUTPUT-
//           *
//          ***
//         *****
//        *******
//       *********


    public static void pattern3(int n){
        int nsp=n/2;
        int nst=1;
        for(int r=1;r<=n;r++){
            for(int csp=1;csp<=nsp;csp++) 
                System.out.print(" ");
            for(int cst=1;cst<=nst;cst++)
                System.out.print("*");
            if(r<n/2+1){
                nsp--;
                nst+=2;
            }else{
                nsp++;
                nst-=2;
            }
            System.out.println();
        }
    }
//OUTPUT-    
//    *
//    ***
//   *****
//  *******
// *********
//  *******
//   *****
//    ***
//     *  


    public static void pattern4(int n){
        int nsp=n-1;
        int nst=1;
        int val=0;
        for(int r=1;r<=n;r++){
            for(int csp=1;csp<=nsp;csp++)
                System.out.print(" ");

            val=r;
            if(r<n/2+1) val=r;
            else val=n-r+1;

            //val=1,2,3,4,5,6,7
            //val=n-i+1
            //val=1,2,3,4,3,2,1


            for(int cst=1;cst<=nst;cst++){
                //print present prepare future.
                System.out.print(val);
                //val=(cst<n/2+1)?val++:val--;
                if(cst<nst/2+1){
                    val++;
                }else{
                    val--;
                }
            } 
            if(r<n/2+1){
                nsp--;
                nst+=2;
            }else{
                //reduce columns.
                nsp++;
                nst-=2;
            }            
            System.out.println();
            
        }
    }

//OUTPUT
//        1
//       232
//      34543
//     4567654
//    567898765
//     4567654
//      34543
//       232
//        1

    public static void pattern5(int n){
        int nsp=n-1;
        int nst=1;
        int val=0;
        for(int r=1;r<=n;r++){
            for(int csp=1;csp<=nsp;csp++)
                System.out.print(" ");

            val=r;
            if(r<n/2+1) val=r;
            else val=n-r+1;
            
            //val=r
            //val=1,2,3,4,5,6,7

            //val=n-i+1
            //val=1,2,3,4,3,2,1


            for(int cst=1;cst<=nst;cst++){
                //print present prepare future.
                System.out.print(val);
                //val=(cst<n/2+1)?val++:val--;
                if(cst<nst/2+1){
                    val--;
                }else{
                    val++;
                }
            } 
            if(r<n/2+1){
                nsp--;
                nst+=2;
            }else{
                //reduce columns.
                nsp++;
                nst-=2;
            }            
            System.out.println();
            
        }
    }
//OUTPUT
//        1
//       212
//      32123
//     4321234
//    543212345
//     4321234
//      32123
//       212
//        1
   
    public static void pattern6(int n){
        int val=1;
        for(int i=0;i<=n;i++){
            val=1;
            for(int j=0;j<=i;j++){
                System.out.print(val +" ");
                val=(val*(i-j))/(j+1);
            }
            System.out.println();
        }
    }
//OUTPUT-
//        1
//        1 1
//        1 2 1
//        1 3 3 1
     

    public static void pattern7(int n){
        //also called pascal triangle.
        int nsp=n-1;
        int nst=1;
        int val=1;
        for(int r=0;r<n;r++){
            for(int csp=0;csp<nsp;csp++) 
                System.out.print(" ");
            val=1;
            for(int cst=0;cst<nst;cst++){
                System.out.print(val+" ");
                val=(val*(r-cst))/(cst+1);
            }
            nst++;
            nsp--;
            System.out.println();            
        }
    }
//OUTPUT-
//        1
//       1 1
//      1 2 1
//     1 3 3 1
//    1 4 6 4 1 

    public static void pattern8(int n){
        int b=(n%2==0)?n/2:n/2+1;
        int i=0;
        int rowEnd=n;
        int colEnd=n;
        int start=0;
        int arr[][] = new int[n][n];
        int count=1;
        while(i<b){
            for(int r=start;r<rowEnd;r++){
                //fill all row's first col with count
                arr[r][start]=count;
                //fill all row's last col woth count
                arr[n-r-1][n-start-1]=count;
            }
            for(int c=start;c<colEnd;c++){
                //fill all col in first row with count
                arr[start][c]=count;
                //fill all col in last row with count
                arr[n-start-1][n-c-1]=count;
            }
            count++;
            start++;
            rowEnd--;
            colEnd--;
            i++;
        }
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                System.out.print(arr[r][c]+" ");
            }
            System.out.println();
        }
    }
//OUTPUT-
//1 1 1 1 1 1 1 1 1
//1 2 2 2 2 2 2 2 1
//1 2 3 3 3 3 3 2 1
//1 2 3 4 4 4 3 2 1
//1 2 3 4 5 4 3 2 1
//1 2 3 4 4 4 3 2 1
//1 2 3 3 3 3 3 2 1
//1 2 2 2 2 2 2 2 1
//1 1 1 1 1 1 1 1 1 
    public static void main(String args[]){
        int n=9;
        pattern8(n);
    }
}