import java.util.Scanner;
class main{
    public static Scanner scn = new Scanner(System.in);
    public static int getDigitCount(int n){
        if(n==0){
            return 1;
        }
        int counter=0;
        while(n>0){
            counter++;
            n=n/10;
        }
        return counter;
    }
    public static void main(String args[]){
        System.out.println("Enter number to rotate");
        int n=scn.nextInt();
        System.out.println("Number of rotations");
        int r=scn.nextInt();
        int digits=getDigitCount(n);
        if(digits==1){
            System.out.println(n);
            System.exit(0);
        }
        r=r%digits;
        if(r<0){
            r=r+digits;
        }

        int divider=1,multiplier=1;
        divider = (int)Math.pow(10,digits-r);
        multiplier = (int)Math.pow(10,r);
        
        /*for(int i=0;i<digits;i++){
            if(i<r){
                multiplier*=10;
            }else{
                divider*=10;
            }
        }*/
        
        int last = n%divider;
        int first = n/divider;
        int ans = last*multiplier+first;   //firstLast => lastFirst

        System.out.print(ans);
        System.exit(0);
    }
}