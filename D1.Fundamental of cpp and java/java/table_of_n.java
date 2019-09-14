import java.util.Scanner;
class main{
    public static void main(String args[]){
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int limit=scn.nextInt();
        for(int i=1;i<=limit;i++){
            System.out.println(n*i);
        }

    }
}